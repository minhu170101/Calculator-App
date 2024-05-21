package com.example.udgt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.XMLReader;

public class Ptb2 extends AppCompatActivity {
    TextView txt_abc,txt_delta,txt_ssdelta,txt_loai,txt_nghiem,txt_nghiem2;
    EditText edt_a,edt_b,edt_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptb2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Giải Phương Trình Bậc 2");

        txt_abc = (TextView) findViewById(R.id.txt_abc);
        txt_delta = (TextView) findViewById(R.id.txt_delta);
        txt_ssdelta = (TextView) findViewById(R.id.txt_ssdelta);
        txt_loai = (TextView) findViewById(R.id.txt_loai);
        txt_nghiem = (TextView) findViewById(R.id.txt_nghiem);
        txt_nghiem2 = (TextView) findViewById(R.id.txt_nghiem2);
        edt_a = (EditText) findViewById(R.id.edt_a);
        edt_b = (EditText) findViewById(R.id.edt_b);
        edt_c = (EditText) findViewById(R.id.edt_c);

    }

    public void Tinh(View view){


        try {
            double a = Double.parseDouble(edt_a.getText().toString());
            double b = Double.parseDouble(edt_b.getText().toString());
            double c = Double.parseDouble(edt_c.getText().toString());

            double delta;
            double x = -c/b;
            double x1,x2;

            txt_abc.setText("a = "+a+"\t\t b = "+b+"\t\t c = "+c);

            if(a==0) {
                if(b==0) {
                    txt_delta.setText("Phương trình vô nghiệm!");
                }
                else {
                    txt_delta.setText("Phương trình có một nghiệm");
                    txt_ssdelta.setText("X = -c/b = -("+c+") / ("+b+") = "+x);
                }
            }
            else {
                delta = b*b - 4*a*c;
                txt_delta.setText(Html.fromHtml("D = b<sup><small>2</small></sup> - 4ac = "+b+"<sup><small>2</small></sup> + 4*"+a+"*"+c+" = "+delta));
                if(delta > 0) {
                    txt_ssdelta.setText("D > 0");
                    x1 = ((-b + Math.sqrt(delta)) / (2*a));
                    x2 = ((-b - Math.sqrt(delta)) / (2*a));
                    txt_loai.setText("Phương trình có 2 nghiệm:");
                    txt_nghiem.setText(Html.fromHtml("X<sub><small>1</small></sub> = (-b + √D) / (2a) = (-("+b+") + √("+delta+") / (2*"+a+") = "+x1));
                    txt_nghiem2.setText(Html.fromHtml("X<sub><small>2</small></sub> = (-b - √D) / (2a) = (-("+b+") - √("+delta+") / (2*"+a+") = "+x2));
                }
                else if(delta == 0) {
                    txt_ssdelta.setText("D = 0");
                    x1 = (-b/(2*a));
                    txt_loai.setText("Phương trình có nghiệm kép:");
                    txt_nghiem.setText(Html.fromHtml("X<sub><small>1</small></sub> = X<sub><small>2</small></sub> = -b/2a = -("+b+") / 2*"+a+" = "+x1));
                }
                else {
                    txt_ssdelta.setText("D < 0");
                    txt_loai.setText("Phương trình vô nghiệm!");
                }
            }

        }
        catch (Exception exception){
            Toast.makeText(Ptb2.this,"Sai định dạng",Toast.LENGTH_SHORT).show();
        }

    }

    public void Reset(View view){
        txt_abc.setText("");
        txt_delta.setText("");
        txt_ssdelta.setText("");
        txt_loai.setText("");
        txt_nghiem.setText("");
        txt_nghiem2.setText("");
        edt_a.setText("");
        edt_b.setText("");
        edt_c.setText("");
    }
}