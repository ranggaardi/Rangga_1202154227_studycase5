package com.example.android.rangga_1202154227_modul5;

/**
 * Created by ranggaardi on 3/25/2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.LinkedList;

public class DataHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "db_List";

    private static final String TABLE_NAME = "tb_TODO";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";
    private static final String KEY_DESC = "desc";
    private static final String KEY_PRIORITY = "priority";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TODO_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT, " +KEY_PRIORITY + " TEXT)";
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }


    public void save(Model model){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME, model.getName());
        values.put(KEY_DESC, model.getDesc());
        values.put(KEY_PRIORITY, model.getPriority());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public LinkedList<Model> findAll(){
        LinkedList<Model> listBuku = new LinkedList<Model>();
        String query="SELECT * FROM "+TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Model mdl = new Model();
                mdl.setId(Integer.valueOf(cursor.getString(0)));
                mdl.setName(cursor.getString(1));
                mdl.setDesc(cursor.getString(2));
                mdl.setPriority(cursor.getString(3));
                listBuku.add(mdl);
            }while(cursor.moveToNext());
        }

        return listBuku;
    }

    public boolean delete(Model todo){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id =" + todo.getId(), null) > 0;
    }
}