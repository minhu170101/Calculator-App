package com.example.udgt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Ứng Dụng Giải Toán");


        listView = (ListView) findViewById(R.id.listview);
        ArrayList<String> item = new ArrayList<>();
        item.add("Máy tính cầm tay");
        item.add("Giải phương trình bậc 1");
        item.add("Giải phương trình bậc 2");

        ArrayAdapter da = new ArrayAdapter(this, android.R.layout.simple_list_item_1,item);
        listView.setAdapter(da);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Intent intent = new Intent(getApplicationContext(), Calculator.class);
                    startActivity(intent);
                }
                else if(i==1)
                {
                    Intent intent = new Intent(getApplicationContext(), Ptb1.class);
                    startActivity(intent);
                }
                else if(i==2)
                {
                    Intent intent = new Intent(getApplicationContext(), Ptb2.class);
                    startActivity(intent);
                }
            }
        });
    }
}