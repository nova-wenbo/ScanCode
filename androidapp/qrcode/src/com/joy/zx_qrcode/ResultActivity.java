/**
 * Date  : 2017-02-14
 * Author: obsession
 * Email : wangwenbo_nova@126.com
 * version : v0.11
 * */
package com.joy.zx_qrcode;

import com.zxing.encoding.EncodingHandler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ResultActivity extends Activity {

	private float y1 = 0;
	private float y2 = 0;
	
	private ImageView mResultImage;
	private EditText mResultText;
	static View view = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Bundle extras = getIntent().getExtras();

		mResultImage = (ImageView) findViewById(R.id.imgcode);
		mResultText = (EditText) findViewById(R.id.editcode);

		if (null != extras) {
			String result = extras.getString("result");
			mResultText.setText(result);
			mResultImage.setImageBitmap((Bitmap)extras.getParcelable("bitmap"));
			
			
	}
		view = this.getWindow().getDecorView();   			
		view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp1));
}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//�̳���Activity��onTouchEvent������ֱ�Ӽ�������¼�
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			//����ָ���µ�ʱ��
			y1 = event.getY();
		}
		if(event.getAction() == MotionEvent.ACTION_UP) {
			//����ָ�뿪��ʱ��
			y2 = event.getY();
			if(y1 - y2 > 50) {
				
				/************************************+20170215-17:30************************************/
				String contentString = mResultText.getText().toString();
				if (!contentString.equals("")) {
					// �����ַ������ɶ�ά��ͼƬ����ʾ�ڽ����ϣ��ڶ�������ΪͼƬ�Ĵ�С��350*350��
					Bitmap qrCodeBitmap = EncodingHandler.createQRCode(
							contentString, 350);
					if (qrCodeBitmap != null)
						mResultImage.setImageBitmap(qrCodeBitmap);
					else
						Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(this, "Text can not be empty",
							Toast.LENGTH_SHORT).show();
				}
				
				//Toast.makeText(ResultActivity.this, "���ϻ�", Toast.LENGTH_SHORT).show();
			}
			else if(y2 - y1 > 50) {
				
				String contentString1 = mResultText.getText().toString();
				if (!contentString1.equals("")) {
					// �����ַ������ɶ�ά��ͼƬ����ʾ�ڽ����ϣ��ڶ�������ΪͼƬ�Ĵ�С��350*350��
					Bitmap qrCodeBitmap = EncodingHandler.creatBarcode(this,
							contentString1, 350, 150, true);
					if (qrCodeBitmap != null)
						mResultImage.setImageBitmap(qrCodeBitmap);
					else
						Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(ResultActivity.this, "Text can not be empty",
							Toast.LENGTH_SHORT).show();
				}
				
			//	Toast.makeText(ResultActivity.this, "���»�", Toast.LENGTH_SHORT).show();
			} 
		}
		return super.onTouchEvent(event);
	}
	
	
	
	public void onClick(View v){
		switch (v.getId()){
		case R.id.result_Button1:
    		Intent intent = new Intent(ResultActivity.this,MenuActivity.class);
    		startActivity(intent);
    		this.finish();
    		break;
		
		}
		
	}
}
