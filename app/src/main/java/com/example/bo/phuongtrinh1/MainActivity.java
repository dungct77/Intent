package com.example.bo.phuongtrinh1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnKetQua;
    EditText edta, edtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edta = (EditText)findViewById(R.id.edta);
        edtb = (EditText) findViewById(R.id.edtb);
        btnKetQua = (Button) findViewById(R.id.btn);
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tạo intent để mở class ResultActivity
                Intent myIntent = new Intent(MainActivity.this,ResultActivity.class);

                if(!edta.getText().toString().isEmpty() && !edtb.getText().toString().isEmpty()){
                    int a = Integer.parseInt(edta.getText().toString());
                    int b = Integer.parseInt(edtb.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);
                    //Dua bundel vao intent
                    myIntent.putExtra("MyPackage", bundle);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show();
                }
            }
        });//đọc trạng thái đã lưu bên ResultActivity
        //b1: gọi ham getSharedPrefenrences
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        int a = sharedPreferences.getInt("soA",0);
        int b = sharedPreferences.getInt("soB",0);
        edta.setHint("0");
        edtb.setHint("0");
        Toast.makeText(MainActivity.this, "Wellcome back to MainActivity ! Your last edit text : a= " + a + "  , b= " + b, Toast.LENGTH_LONG).show();



    }
}
