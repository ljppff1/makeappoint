package com.example.makeappoint;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class ReservationActivity extends SlidingFragmentActivity {

	private RelativeLayout mRlLeft;
	private Fragment mContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.reservation);
      		
		initSlidingMenu(savedInstanceState);  
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

			default:
				break;
			}
		}
	};

}
