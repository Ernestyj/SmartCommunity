package com.example.smartcommunity.imp;

import com.example.smartcommunity.R;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;

public class ViewPagerChangeListener implements OnPageChangeListener {
	private ImageView[] pointImageViews;
	public ViewPagerChangeListener(ImageView[] imgs){
		pointImageViews = imgs;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		for(int i=0;i<pointImageViews.length;i++){
			pointImageViews[position].setBackgroundResource(R.drawable.page_indicator_focused);
			//不是当前选中的page，其小圆点设置为未选中的状态
			if(position !=i){
				pointImageViews[i].setBackgroundResource(R.drawable.page_indicator);
			}
		}
	}

}
