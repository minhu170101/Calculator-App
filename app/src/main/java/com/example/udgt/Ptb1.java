package com.example.udgt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ptb1 extends AppCompatActivity {
    TextView txt_xb1,txt_ab;
    EditText edt_ab1,edt_bb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptb1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Giải Phương Trình Bậc 1");

        txt_ab = (TextView) findViewById(R.id.txt_ab);
        txt_xb1 = (TextView) findViewById(R.id.txt_xb1);
        edt_ab1 = (EditText) findViewById(R.id.edt_ab1);
        edt_bb1 = (EditText) findViewById(R.id.edt_bb1);
    }

    public void tinh(View view) {
        try{
            double a = Double.parseDouble(edt_ab1.getText().toString());
            double b = Double.parseDouble(edt_bb1.getText().toString());

            double x;

            if(a == 0) {
                if(b == 0){
                    txt_ab.setText("a = "+a+"\t\t b = "+b);
                    txt_xb1.setText("Phương trình có vô số nghiệm");
                }
                else{
                    txt_ab.setText("a = "+a+"\t\t b = "+b);
                    txt_xb1.setText("Phương trình vô nghiệm");
                }
            }
            else{
                x = -b/a;
                txt_ab.setText("a = "+a+"\t\t b = "+b);
                txt_xb1.setText("x = -b/a = -("+b+") / "+a+" = "+x);
            }
        }
        catch (Exception ex){
            Toast.makeText(Ptb1.this,"Sai định dạng",Toast.LENGTH_SHORT).show();
        }
    }

    public void reset(View view) {
        txt_ab.setText("");
        txt_xb1.setText("");
        edt_ab1.setText("");
        edt_bb1.setText("");
    }
}