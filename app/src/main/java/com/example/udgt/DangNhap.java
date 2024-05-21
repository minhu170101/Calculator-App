package com.example.udgt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhap extends AppCompatActivity {

    EditText dn_tdn,dn_mk;
    Button btn_dn, btn_next;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        dn_tdn = (EditText) findViewById(R.id.dn_tdn);
        dn_mk = (EditText) findViewById(R.id.dn_mk);
        btn_dn = (Button) findViewById(R.id.btn_dn);
        btn_next = (Button) findViewById(R.id.btn_next);
        DB = new DBHelper(this);

        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = dn_tdn.getText().toString();
                String pass = dn_mk.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(DangNhap.this,"Hãy nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(DangNhap.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(DangNhap.this,"Thông tin không chính xác vui lòng nhập lại",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DangKy.class);
                startActivity(intent);
            }
        });
    }
}