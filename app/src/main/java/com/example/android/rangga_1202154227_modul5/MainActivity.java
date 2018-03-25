package com.example.android.rangga_1202154227_modul5;


import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Model> WordList = new LinkedList<>();
    private int mCount = 0;
    private RecyclerView RecyclerView;
    private adapter Adapter;
    private DataHelper dtHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dtHelper = new DataHelper(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.bar);
        setSupportActionBar(toolbar);
        setRecyclerView();

    }
    public void tambah(View view) {

        Intent intent = new Intent(this, IsiDataActivity.class);
        startActivityForResult(intent, 1);
    }

    public void setRecyclerView(){
        WordList = dtHelper.findAll();
        RecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Adapter = new adapter(this, WordList);

        RecyclerView.setAdapter(Adapter);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.Callback callback = new hapus_swipe(Adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(RecyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1){
            Log.d("new name : ",data.getStringExtra("name"));
            Log.d("new desc : ",data.getStringExtra("desc"));
            Log.d("new priority : ",data.getStringExtra("priority"));
            dtHelper.save(new Model(data.getStringExtra("name"), data.getStringExtra("desc"), data.getStringExtra("priority")));
        }
        setRecyclerView();
        Adapter.notifyDataSetChanged();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {

            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.pilih_warna);
            dialog.setTitle("Change");
            dialog.setCancelable(true);

            final RadioButton rdRed = (RadioButton) dialog.findViewById(R.id.rdRed);
            final RadioButton rdBlue = (RadioButton) dialog.findViewById(R.id.rdBlue);
            final RadioButton rdGreen = (RadioButton) dialog.findViewById(R.id.rdGreen);

            Button btnChange = (Button)dialog.findViewById(R.id.btnChange);

            btnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rdRed.isChecked()){
                        RecyclerView.setBackgroundResource(R.color.redBackgroud);
                        Toast.makeText(view.getContext(),"Red Choosen",Toast.LENGTH_SHORT).show();
                    }
                    if (rdBlue.isChecked()){
                        RecyclerView.setBackgroundResource(R.color.blueBackgroud);
                        Toast.makeText(view.getContext(),"Blue Choosen",Toast.LENGTH_SHORT).show();
                    }
                    if (rdGreen.isChecked()){
                        RecyclerView.setBackgroundResource(R.color.greenBackgroud);
                        Toast.makeText(view.getContext(),"Green Choosen",Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(view.getContext(),"Changed",Toast.LENGTH_SHORT).show();
                }
            });

            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

}
