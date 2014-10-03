package aitp.r3conf.org.team12mobileapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;


public class ViewItemList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item_list);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ViewCategories.EXTRA_MESSAGE);
        TextView category = (TextView)findViewById(R.id.category);
        category.setText(message);

        DataAdapter myDbHelper = new DataAdapter(this);
        myDbHelper.createDatabase();
        myDbHelper.open();
        ArrayList<Item> dbValues = myDbHelper.getAllByCategory((String) category.getText());
        myDbHelper.close();

        category.setText((CharSequence) dbValues.get(0).name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_item_list, menu);
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
}
