package com.joy.zx_qrcode;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class WarnActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_warn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.warn, menu);
		return true;
	}

	
	public void onClick(View v){
		switch(v.getId()){
		case R.id.warn_Button1:
			WarnActivity.this.finish();
		break;
		default:
			break;
		}
		
	}

}
