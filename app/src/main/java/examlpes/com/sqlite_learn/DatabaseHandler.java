package examlpes.com.sqlite_learn;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dinesh on 24-02-2017.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=5;
    public static final String DATABASE_NAME="Testing_Database";
    public static  final String TABLE_CONTACTS="Testing_table";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                    + KEY_PH_NO + " TEXT" + ")";
            sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
            Log.e("Database", "Creation");
        }catch (Exception e){

        e.printStackTrace();
    }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACTS);
        onCreate(sqLiteDatabase);

    }

    // code to add the new contact
    void addContact(String name, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Contact Name
        values.put(KEY_PH_NO, phone); // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
}
