package aitp.r3conf.org.team12mobileapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.SQLException;


public class ViewItemDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item_details);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_item_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showItemDetail(int id){
        DataBaseHelper dbHelper = new DataBaseHelper(this);
        try {
            dbHelper.onOpen(dbHelper.DB_NAME);
        } catch (SQLException e) {
            Log.v("TEST","Could Not Open Database");
        }

        String query = "SELECT * FROM item WHERE id = " + id;
        dbHelper.getReadableDatabase();


    }

}
