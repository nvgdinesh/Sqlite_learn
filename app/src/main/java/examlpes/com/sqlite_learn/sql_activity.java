package examlpes.com.sqlite_learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class sql_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_activity);

        DatabaseHandler db = new DatabaseHandler(this);


        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact("Ravi", "9100000000");
        db.addContact("Srinivas", "9199999999");
        db.addContact("Tommy", "9522222222");
        db.addContact("Karthik", "9533333333");
    }
}
