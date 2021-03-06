package com.example.androidlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	public static final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");		
		
		setContentView(R.layout.activity_main);

		if (savedInstanceState != null) {
			String tempData = savedInstanceState.getString("data_key");
			Log.d(TAG, tempData);
		}
		
		Button startNormalActivity = (Button) findViewById(R.id.start_dialog_activity);
		Button startDialogActivity = (Button) findViewById(R.id.start_normal_activity);

		startNormalActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, NormalActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});

		startDialogActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, DialogActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});	
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart");
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		String tempData = "Someting you just typed in";
		outState.putString("data_key", tempData);
	}

}
