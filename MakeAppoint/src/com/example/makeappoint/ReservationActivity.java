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
     * 初始化侧边栏 
     */  
    private void initSlidingMenu(Bundle savedInstanceState) {  
        
  
        // 设置左侧滑动菜单  
        setBehindContentView(R.layout.menu_frame_left1);  
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.menu_frame, new LeftFragment()).commit();
		
        // 实例化滑动菜单对象  
        SlidingMenu sm = getSlidingMenu();  
        // 设置可以左右滑动的菜单  
        sm.setMode(SlidingMenu.LEFT);  
        // 设置滑动阴影的宽度  
        sm.setShadowWidthRes(R.dimen.shadow_width);  
        // 设置滑动菜单阴影的图像资源  
        sm.setShadowDrawable(null);  
        // 设置滑动菜单视图的宽度  
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);  
        // 设置渐入渐出效果的值  
        sm.setFadeDegree(0.35f);  
        // 设置触摸屏幕的模式,这里设置为全屏  
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  
        // 设置下方视图的在滚动时的缩放比例  
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
