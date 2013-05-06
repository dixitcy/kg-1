package com.dcy.karaokegarage;



import android.app.Application;
import android.util.Log;

public class kgapp extends Application{
  static final String TAG="kgapp";
	Songdatabase info;

	@Override
	public void onCreate() {
		
		super.onCreate();
		
		info=new Songdatabase(this); 
		Log.d(TAG,"OnCreated");
	}

}
