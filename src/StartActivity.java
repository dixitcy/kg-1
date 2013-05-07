package com.dcy.karaokegarage;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;


public class StartActivity extends Activity implements OnClickListener{
	
	Button sqlView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		LinearLayout rlayout = (LinearLayout) findViewById(R.id.LinearLayout1);
		  rlayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()){
				
				case R.id.LinearLayout1:
					Intent i=new Intent(getApplicationContext(),songsActivity.class);
					startActivity(i);
					
					break;
				}
				
			}

		        
		   });
	//	sqlView=(Button)findViewById(R.id.bSQLopenView);
	//	sqlView.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		
	}

}
