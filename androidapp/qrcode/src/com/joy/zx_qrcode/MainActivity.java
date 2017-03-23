package com.joy.zx_qrcode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zxing.encoding.EncodingHandler;

public class MainActivity extends Activity implements OnClickListener {

	EditText editcode;
	ImageView imgcode;
	Button btnscan, btnQrcode, btnbarcode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab02);
		editcode = (EditText) findViewById(R.id.editcode);
		imgcode = (ImageView) findViewById(R.id.imgcode);
		btnscan = (Button) findViewById(R.id.btnScan);
		btnQrcode = (Button) findViewById(R.id.btnQrcode);
		btnbarcode = (Button) findViewById(R.id.btnbarcode);
		btnscan.setOnClickListener(this);
		btnQrcode.setOnClickListener(this);
		btnbarcode.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnScan:
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, CaptureActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivityForResult(intent, 1);
			break;
		case R.id.btnQrcode:
			String contentString = editcode.getText().toString();
			if (!contentString.equals("")) {
				// 根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
				Bitmap qrCodeBitmap = EncodingHandler.createQRCode(
						contentString, 350);
				if (qrCodeBitmap != null)
					imgcode.setImageBitmap(qrCodeBitmap);
				else
					Toast.makeText(this, "解析错误", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Text can not be empty",
						Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btnbarcode:
			String contentString1 = editcode.getText().toString();
			if (!contentString1.equals("")) {
				// 根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
				Bitmap qrCodeBitmap = EncodingHandler.creatBarcode(this,
						contentString1, 350, 150, true);
				if (qrCodeBitmap != null)
					imgcode.setImageBitmap(qrCodeBitmap);
				else
					Toast.makeText(this, "解析错误", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(MainActivity.this, "Text can not be empty",
						Toast.LENGTH_SHORT).show();
			}
           break;
		
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				// 显示扫描到的内容
				editcode.setText(bundle.getString("result"));
				// 显示
				imgcode.setImageBitmap((Bitmap)  bundle.getParcelable("bitmap"));
			}
			break;
		}
	}
}
