/**
 * Date  : 2017-02-14
 * Author: obsession
 * Email : wangwenbo_nova@126.com
 * version : v0.11
 * */
package com.joy.zx_qrcode;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends Activity implements
		android.view.View.OnClickListener {
	
	EditText editcode;
	ImageView imgcode;
	

	private ViewPager mViewPager;// �������ý����л�
	private PagerAdapter mPagerAdapter;// ��ʼ��View������
	private List<View> mViews = new ArrayList<View>();// �������Tab01-04
	// �ĸ�Tab��ÿ��Tab����һ����ť
	private LinearLayout mTabWeiXin;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSetting;
	// �ĸ���ť
	private ImageButton mWeiXinImg;
	private ImageButton mAddressImg;
	private ImageButton mSettingImg;

	private TextView textButton1;
	private TextView textButton2;
	private TextView textButton3;

	static View view = null;
	String vb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu);
		initView();
		initViewPage();
		initEvent();		
		editcode = (EditText) findViewById(R.id.editcode);
		imgcode = (ImageView) findViewById(R.id.imgcode);
	//	view = this.getWindow().getDecorView();   
		
	//	view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp1));
/*		Intent intent = getIntent(); 
		String value = intent.getStringExtra("testIntent"); 
		if(value.equals(str)){
			view = this.getWindow().getDecorView();  
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp1));				
		}*/
		
		
		//View v = findViewById(R.id.gongneng_shima);
		//v.getBackground().setAlpha(100);

			view = this.getWindow().getDecorView();   			
			view.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.wp4));						
	}

	private void initEvent() {
		mTabWeiXin.setOnClickListener(this);
		mTabAddress.setOnClickListener(this);
		mTabSetting.setOnClickListener(this);
		
		textButton1.setOnClickListener(this);
		textButton2.setOnClickListener(this);
		textButton3.setOnClickListener(this);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
            /**
            *ViewPage���һ���ʱ
            */
			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				switch (currentItem) {
				case 0:
					 resetImg();
					mWeiXinImg.setImageResource(R.drawable.seting5);
					textButton1.setTextColor(Color.parseColor("#1296db"));//������ɫ  
					break;
				case 1:
					 resetImg();
					mAddressImg.setImageResource(R.drawable.seting1);
					textButton2.setTextColor(Color.parseColor("#1296db"));//������ɫ  
					break;
				case 2:
					 resetImg();
					mSettingImg.setImageResource(R.drawable.seting3);
					textButton3.setTextColor(Color.parseColor("#1296db"));//������ɫ  
					break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	/**
	 * ��ʼ������
	 */
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpage);
		// ��ʼ���ĸ�LinearLayout
		mTabWeiXin = (LinearLayout) findViewById(R.id.id_tab_weixin);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
		mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
		// ��ʼ���ĸ���ť
		mWeiXinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
		mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
		mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);
		
		textButton1 = (TextView) findViewById(R.id.text_in_xml);
		textButton2 = (TextView) findViewById(R.id.text2);
		textButton3 = (TextView) findViewById(R.id.text3);
	}

	/**
	 * ��ʼ��ViewPage
	 */
	private void initViewPage() {

		// ���軯�ĸ�����
		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		View tab01 = mLayoutInflater.inflate(R.layout.tab01, null);
		View tab02 = mLayoutInflater.inflate(R.layout.tab02, null);
		View tab03 = mLayoutInflater.inflate(R.layout.tab03, null);

		mViews.add(tab01);
		mViews.add(tab02);
		mViews.add(tab03);

		// ��������ʼ��������
		mPagerAdapter = new PagerAdapter() {

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(mViews.get(position));

			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {

				return arg0 == arg1;
			}

			@Override
			public int getCount() {

				return mViews.size();
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
	}

	/**
	 * �ж��ĸ�Ҫ��ʾ�������ð�ťͼƬ
	 */
	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()) {
		case R.id.id_tab_weixin:
			mViewPager.setCurrentItem(0);
			resetImg();
			mWeiXinImg.setImageResource(R.drawable.seting5);
			textButton1.setTextColor(Color.parseColor("#1296db"));
			break;
		case R.id.id_tab_address:
			mViewPager.setCurrentItem(1);
			resetImg();
			mAddressImg.setImageResource(R.drawable.seting1);
			textButton2.setTextColor(Color.parseColor("#1296db"));
		//	Intent intent = new Intent(MenuActivity.this,MainActivity.class);
		//	startActivity(intent);
			break;
		case R.id.id_tab_settings:
			mViewPager.setCurrentItem(3);
			resetImg();
			mSettingImg.setImageResource(R.drawable.seting3);
			textButton3.setTextColor(Color.parseColor("#1296db"));
			break;
		default:
			break;
		}
	}

	/**
	 * ������ͼƬ�䰵
	 */
	private void resetImg() {
		mWeiXinImg.setImageResource(R.drawable.seting6);
		mAddressImg.setImageResource(R.drawable.seting2);
		mSettingImg.setImageResource(R.drawable.seting4);
		textButton3.setTextColor(Color.parseColor("#000000"));
		textButton2.setTextColor(Color.parseColor("#000000"));
		textButton1.setTextColor(Color.parseColor("#000000"));
	}
	
	
	public void onFack(View v){
		switch (v.getId()) {
        case R.id.my_button_id:   //��ҳ.��ť
          //  Toast.makeText(getApplicationContext(), "button�Լ���һ����������", 0).show();
        	new  AlertDialog.Builder(MenuActivity.this)
        	.setTitle("��ʾ" )
        	.setMessage("���ã���ӭʹ��ɨ�룡")
        	.setPositiveButton("ȡ��",null)
        	.show();		
            break;
    	case R.id.gongneng_shima:   //����.ʶ���ά��
			Intent intent = new Intent(MenuActivity.this,CaptureActivity.class);
			startActivity(intent);
			break;
    	case R.id.btn_list_item_bg:    //������һ��
    		System.exit(0);
    		break;
    	case R.id.shezhi_guanyusaoma:   //����.����ɨ��
    		Intent intent1 = new Intent(MenuActivity.this, WarnActivity.class);
			startActivity(intent1);
    		break;
    	case R.id.gongneng_chanma1:   //������ά��
    		Intent intent2 = new Intent(MenuActivity.this, ResultActivity.class);
			startActivity(intent2);
    		break;
    	case R.id.seting_pifu:
    		Intent intent3 = new Intent(MenuActivity.this, SkinActivity.class);
			startActivity(intent3);
    		break;
        default:
            break;
        }
		
	}	
}
