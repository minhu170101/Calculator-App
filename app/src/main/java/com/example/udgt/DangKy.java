package com.example.udgt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangKy extends AppCompatActivity {

    EditText dk_tdn,dk_mk,dk_nlmk;
    Button btn_dk,btn_back;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        this.getSupportActionBar().hide();

        dk_tdn = (EditText) findViewById(R.id.dk_tdn);
        dk_mk = (EditText) findViewById(R.id.dk_mk);
        dk_nlmk = (EditText) findViewById(R.id.dk_nlmk);
        btn_dk = (Button) findViewById(R.id.btn_dk);
        btn_back = (Button) findViewById(R.id.btn_back);
        DB = new DBHelper(this);

        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = dk_tdn.getText().toString();
                String pass = dk_mk.getText().toString();
                String repass = dk_nlmk.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(DangKy.this,"Hãy nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(DangKy.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),DangNhap.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(DangKy.this,"Đăng ký không thành công",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(DangKy.this,"Tên đăng nhập đã có người sử dụng",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(DangKy.this,"Mật khẩu không trùng nhau",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DangNhap.class);
                startActivity(intent);
            }
        });
    }
}
