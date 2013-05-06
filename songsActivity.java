package com.dcy.karaokegarage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Songdatabase {
  public static final String TAG = "Songbase";
	public static final String KEY_ROWID = "_id";
	public static final String KEY_SONGNAME = "song_name";
	public static final String KEY_ALBUMNAME = "album_name";
	public static final String KEY_LANGUAGE = "_lang";

	private static final String DATABASE_NAME = "songlist.db";
	private static final String DATABASE_TABLE = "songstable";
	private static final int DATABASE_VERSION = 1;

	DbHelper ourdbhelper;
	Context ourcontext;
	SQLiteDatabase ourdatabase;
	Cursor cursor;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_SONGNAME
					+ " TEXT NOT NULL, " + KEY_ALBUMNAME + " TEXT NOT NULL, "
					+ KEY_LANGUAGE + " TEXT NOT NULL);");
			Log.d(TAG, "oncreate with sql");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}

	}

	public Songdatabase(Context c) {
		ourcontext = c;
	}

	public Songdatabase open() {
		ourdbhelper = new DbHelper(ourcontext);
		ourdatabase = ourdbhelper.getWritableDatabase();
		return this;
	}

	public void close() {
		ourdbhelper.close();
	}

	public long createEntry(String songname, String albumname, String language) {

		ContentValues values = new ContentValues();
		values.put(KEY_SONGNAME, songname);
		values.put(KEY_ALBUMNAME, albumname);
		values.put(KEY_LANGUAGE, language);
		return ourdatabase.insert(DATABASE_TABLE, null, values);
	}

	public Cursor query() {

		Cursor cursor = ourdatabase.query(DATABASE_TABLE, null, null, null,
				null, null, null);

		/*
		 * String result = "";
		 * 
		 * int iRow = cursor.getColumnIndex(KEY_ROWID); int iSongname =
		 * cursor.getColumnIndex(KEY_SONGNAME); int iAlbunmname =
		 * cursor.getColumnIndex(KEY_ALBUMNAME); int iLanguage =
		 * cursor.getColumnIndex(KEY_LANGUAGE);
		 * 
		 * for (cursor.moveToFirst(); !cursor.isAfterLast();
		 * cursor.moveToNext()) { result = result + cursor.getString(iRow) + " "
		 * + cursor.getString(iSongname) + " " + cursor.getString(iAlbunmname) +
		 * " " + cursor.getString(iLanguage) + "\n";
		 * 
		 * }
		 */

		return cursor;
	}
}

