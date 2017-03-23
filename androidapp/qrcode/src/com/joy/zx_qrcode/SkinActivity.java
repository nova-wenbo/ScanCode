package com.joy.zx_qrcode;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;


public class SkinActivity extends Activity implements OnClickListener{
	static View view = null;
	Activity mActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skin);
			
		view = this.getWindow().getDecorView();   
		view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp1));
		
		
		findViewById(R.id.imageView1).setOnClickListener(this);
        findViewById(R.id.imageView2).setOnClickListener(this);
        findViewById(R.id.imageView3).setOnClickListener(this);
        findViewById(R.id.imageView4).setOnClickListener(this);
        findViewById(R.id.imageView5).setOnClickListener(this);
        findViewById(R.id.imageView6).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);   		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.skin, menu);
		return true;
	}

     
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageView1:
			view = this.getWindow().getDecorView();   
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp1));
	
			break;
		case R.id.imageView2:
		
			view = this.getWindow().getDecorView();   
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp2));
			break;
		case R.id.imageView3:
			view = this.getWindow().getDecorView();   
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp3));

			break;
		case R.id.imageView4:
			view = this.getWindow().getDecorView();   
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp4));
		
			break;
		case R.id.imageView5:
			view = this.getWindow().getDecorView();   
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp5));

			break;
		case R.id.imageView6:
			view = this.getWindow().getDecorView();   
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp6));
			break;
		case R.id.btn1:
		
			break;
		case R.id.btn2:

			break;
		case R.id.btn3:

			break;
		case R.id.btn4:
	
			break;
		case R.id.btn5:
		
			break;
		case R.id.btn6:

			break;
		case R.id.btn7:

			break;
		case R.id.btn8:

			break;
		case R.id.shezhipifu_Button1:
			finish();	
			break;
		}
	}

}
