package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    ArrayList <String> arrayCourse;
    Button btnMo,btnCN, btnXoa;
    EditText edtMH;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.Listviewmonhoc);
        btnMo = (Button) findViewById(R.id.button);
        edtMH = (EditText) findViewById(R.id.edtext);
        btnCN = (Button) findViewById(R.id.sua);
        btnXoa = (Button) findViewById(R.id.xoa);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("ios");
        arrayCourse.add("Unity");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvMonHoc.setAdapter(adapter);
        btnMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edtMH.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMH.setText(arrayCourse.get(i));
                vitri = i;
            }
        });
        btnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            arrayCourse.set(vitri, edtMH.getText().toString());
            adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object obj = lvMonHoc.getAdapter().getItem(i);
                String value= obj.toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("value", value);
                startActivity(intent);
                return false;
            }
        });
    }

}