package aitp.r3conf.org.team12mobileapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import java.sql.SQLException;
import java.util.ArrayList;


public class ViewItemList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item_list);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ViewCategories.EXTRA_MESSAGE);

        DataAdapter myDbHelper = new DataAdapter(this);
        myDbHelper.createDatabase();
        myDbHelper.open();
        ArrayList<Item> dbValues = myDbHelper.getAllByCategory(message);
        myDbHelper.close();

        TextView [] txt =new TextView[10];
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.info);
        for(int i=0;i<dbValues.size();i++)
        {
            txt[i]=new TextView(ViewItemList.this);
            txt[i].setText(dbValues.get(i).name);
            txt[i].setLayoutParams(new
                    LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            linearLayout.addView(txt[i]);
        }
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
