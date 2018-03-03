package com.example.bo.phuongtrinh1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
   TextView tv_kq;
EditText edta, edtb;

   Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_kq = (TextView) findViewById(R.id.tv_kq);
        edta = (EditText) findViewById(R.id.edta);
        edtb = (EditText) findViewById(R.id.edtb);

        // get lấy intent đã gọi ResultActivity
        Intent callerIntent = getIntent();

        // get lấy bundle đã gửi
         final Bundle packBundle = callerIntent.getBundleExtra("MyPackage");
         // get gia tri a, b đã chuyển sang

        int a = packBundle.getInt("soA");
        int b = packBundle.getInt("soB");

        // xu ly gia pt
        giaiPTBN(a,b);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ResultActivity.this, MainActivity.class);

                Bundle bundle = packBundle;

                myIntent.putExtra("MyPackage", bundle);
                startActivity(myIntent);
            }
        });
        //Tao đối tượng Editor để cho phép chỉnh sửa dữ liệu
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Đưa dữ liệu muốn lưu vào edit..
        editor.putInt("soA", a);
        editor.putInt("soB", b);
        //Lưu trạng thái
        editor.commit();
}


    public void giaiPTBN(int a , int b){
        if ( a==0){
            if (b==0){
                tv_kq.setText("Phuong Trinh Vo So Nghiem");
                return;
            }else{
            tv_kq.setText("Phương Trình Vô Nghiệm");
                }
        }else{tv_kq.setText(String.valueOf((float)-b/a));
            }
    }
}
