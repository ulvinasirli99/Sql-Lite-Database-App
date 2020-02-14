package devloper.game.sqldatabasefinishlearn.SQL_MODEL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SqlHelper extends SQLiteOpenHelper {

    Context context;

    private static String DbName="EMPLOYEES";
    private static int Version=3;


    private static String TB_Tablename="DB_Tablename";
    private static String CL_Id="CL_Id";
    private static String CL_Name="DB_Name";
    private static String Cl_Email="DB_Email";
    private static String Cl_Password="DB_Password";



    public SqlHelper(Context context) {
        super(context, DbName, null, Version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TB_Tablename +"(" +
                CL_Id + " INTEGER PRIMARY KEY ,"+
                CL_Name + " TEXT, "
                +Cl_Email + " TEXT, "
                +Cl_Password + " TEXT " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TB_Tablename);
        onCreate(db);

    }

    public long InsertColumn(String CP_Name, String CP_Email, String CP_Password){


        SQLiteDatabase sql = this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(CL_Name,CP_Name);
        contentValues.put(Cl_Email,CP_Email);
        contentValues.put(Cl_Password,CP_Password);



      long res=  sql.insert(TB_Tablename,null,contentValues);

        return res;
    }

    public boolean checkUser(String username,String passwrod){

        String[] columns={CL_Id};

        SQLiteDatabase db=this.getReadableDatabase();

        String select=Cl_Email + "=?" + " and " + Cl_Password + "=?";

        String[] selectControl = {username,passwrod};


        Cursor cursor=db.query(TB_Tablename,columns,select,selectControl,null,null,null);

        int count=cursor.getCount();
        cursor.close();
        db.close();


        if (count>0){
            return true;
        }else {
            return false;
        }
    }

    public  void removeAcc(){

        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TB_Tablename,CL_Id,null);
        db.delete(TB_Tablename,CL_Name,null);
        db.delete(TB_Tablename,Cl_Email,null);
        db.delete(TB_Tablename,Cl_Password,null);
        db.close();

    }

}
