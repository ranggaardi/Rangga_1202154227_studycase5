package com.example.android.rangga_1202154227_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IsiDataActivity extends AppCompatActivity {
    private EditText name, Desc, Priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.isi_data);

        name = (EditText)findViewById(R.id.nama);
        Desc = (EditText)findViewById(R.id.des);
        Priority = (EditText)findViewById(R.id.pri);
    }

    public void apply(View view) {
        Intent intent=new Intent();

        intent.putExtra("name",name.getText().toString());
        intent.putExtra("desc",Desc.getText().toString());
        intent.putExtra("priority",Priority.getText().toString());

        setResult(1,intent);
        finish();
    }
}