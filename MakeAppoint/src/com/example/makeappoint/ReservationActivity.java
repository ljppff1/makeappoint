package com.example.makeappoint;

import com.example.calendar_02.ChooseAppointActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ReservationActivity extends SlidingFragmentActivity {

	private RelativeLayout mRlLeft;
	private Fragment mContent;
	private Button mBtReser1;
	private Button mBtReser3;
	private Button mBtReser4;
	private long exitTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.reservation);
      		
		initSlidingMenu(savedInstanceState);  
		mBtReser1 =(Button)this.findViewById(R.id.mBtReser1);
		mBtReser1.setOnClickListener(listener);
		mBtReser3 =(Button)this.findViewById(R.id.mBtReser3);
		mBtReser3.setOnClickListener(listener);
		mBtReser4 =(Button)this.findViewById(R.id.mBtReser4);
		mBtReser4.setOnClickListener(listener);
		
		initView();

	}
    /** 
     * ��ʼ������� 
     */  
    private void initSlidingMenu(Bundle savedInstanceState) {  
        
  
        // ������໬���˵�  
        setBehindContentView(R.layout.menu_frame_left1);  
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.menu_frame, new LeftFragment()).commit();
		
        // ʵ���������˵�����  
        SlidingMenu sm = getSlidingMenu();  
        // ���ÿ������һ����Ĳ˵�  
        sm.setMode(SlidingMenu.LEFT);  
        // ���û�����Ӱ�Ŀ��  
        sm.setShadowWidthRes(R.dimen.shadow_width);  
        // ���û����˵���Ӱ��ͼ����Դ  
        sm.setShadowDrawable(null);  
        // ���û����˵���ͼ�Ŀ��  
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);  
        // ���ý��뽥��Ч����ֵ  
        sm.setFadeDegree(0.35f);  
        // ���ô�����Ļ��ģʽ,��������Ϊȫ��  
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  
        // �����·���ͼ���ڹ���ʱ�����ű���  
        sm.setBehindScrollScale(0.0f);  
  
    }  
	private void initView() {
		mRlLeft =(RelativeLayout)this.findViewById(R.id.mRlre1);
		mRlLeft.setOnClickListener(listener);
	}
	OnClickListener listener =new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mRlre1:
				toggle();
				break;
			case R.id.mBtReser1:
				startActivity(new Intent(getApplicationContext(), ChoservaActivity.class));
				
				break;
			case R.id.mBtReser3:
				startActivity(new Intent(getApplicationContext(), ChooseAppointActivity.class));

				break;
			case R.id.mBtReser4:
				startActivity(new Intent(getApplicationContext(), ChoservaActivity.class));

				break;

			default:
				break;
			}
		}
	};

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK){
			if((System.currentTimeMillis() - exitTime) > 2000){
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.t11), 1).show();
				exitTime = System.currentTimeMillis();
				}else{
					finish();
					android.os.Process.killProcess(android.os.Process.myPid());
				}
			return true;
			}
		return super.dispatchKeyEvent(event);
	}

}
