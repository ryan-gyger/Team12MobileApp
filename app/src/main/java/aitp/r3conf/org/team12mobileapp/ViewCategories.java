package aitp.r3conf.org.team12mobileapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ViewCategories extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.team12mobileapp.CATEGORY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_categories);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_categories, menu);
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

    public void sendCategory(View view) {
        int id = view.getId();
        String message = "";
        switch (id){
            case R.id.hats:
                message = "Hats";
                break;
            case R.id.lanyards:
                message = "Lanyards";
                break;
            case R.id.pens:
                message = "Pens";
                break;
            case R.id.shirts:
                message = "Shirts";
                break;
        }
        Intent intent = new Intent(this, ViewItemList.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
