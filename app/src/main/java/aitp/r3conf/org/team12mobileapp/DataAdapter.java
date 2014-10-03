package aitp.r3conf.org.team12mobileapp;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataAdapter
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public DataAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public DataAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public ArrayList<Item> getAllByCategory(String category) {
        try
        {
            String sql ="SELECT * FROM item";

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                mCur.moveToNext();
            }
            ArrayList<Item> list = new ArrayList<Item>();
            // Select All Query
            String selectQuery = "SELECT * FROM item where category = \'" + category + "\'";

            Cursor cursor = mDb.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Item obj = new Item(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getDouble(3),
                            cursor.getInt(4),
                            cursor.getString(5)
                    );

                    list.add(obj);
                } while (cursor.moveToNext());
            }

            // return  list
            return list;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getAll >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

    public ArrayList<Item> getAll()
    {
        try
        {
            String sql ="SELECT * FROM item";

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                mCur.moveToNext();
            }
            ArrayList<Item> list = new ArrayList<Item>();
            // Select All Query
            String selectQuery = "SELECT  * FROM item";

            Cursor cursor = mDb.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Item obj = new Item(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3),
                        cursor.getInt(4),
                        cursor.getString(5)
                    );

                    list.add(obj);
                } while (cursor.moveToNext());
            }

            // return  list
            return list;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getAll >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }
}