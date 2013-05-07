package com.dcy.karaokegarage;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;

public class songsActivity extends Activity {
	static final String[] FROM = { Songdatabase.KEY_SONGNAME,
			Songdatabase.KEY_ALBUMNAME, Songdatabase.KEY_LANGUAGE };
	static final int[] TO = { R.id.songtitle, R.id.artisttitle,
			R.id.text_createdat };

	public static String songname = "aisdv";
	public static String albumname = "aisdv";
	public static String language = "aisdv";
	SimpleCursorAdapter adapter;
	Cursor cursor;
	ListView list;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.songslist);
		songname = "Stairway to Heaven";
		albumname = "Led Zeppelin";
		language = "English";

		Songdatabase entry = new Songdatabase(this);
		entry.open();
		entry.createEntry(songname, albumname, language);

		entry.close();
		songname = "Pani da";
		albumname = "vicky donor";
		language = "hindi";

		entry.open();
		entry.createEntry(songname, albumname, language);

		entry.close();
		songname = "Why dis Kolaveri di?";
		albumname = "Three";
		language = "Tamil";

		entry.open();
		entry.createEntry(songname, albumname, language);

		entry.close();
		songname = "Hey Jude";
		albumname = "The Beatles";
		language = "English";

		entry.open();
		entry.createEntry(songname, albumname, language);

		entry.close();

		ListView list = (ListView) findViewById(R.id.list);

		cursor = ((kgapp) getApplication()).info.open().query();
		adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, FROM, TO);

		list.setAdapter(adapter);

		// info.open();
		// String data = info.getData();
		// ;
		// info.close();

	}

}
