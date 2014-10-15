package com.example.smartcommunity.imp;

import java.util.ArrayList;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends PagerAdapter {
	private ArrayList<View> pageViews;
	public ViewPagerAdapter(ArrayList<View> pvs) {
		pageViews = pvs;
	}
	
	//销毁position位置的界面
	@Override
	public void destroyItem(ViewGroup v, int position, Object o) {
		v.removeView(pageViews.get(position));
	}

	@Override
	public void finishUpdate(View arg0) {
	}
	
	//获取当前窗体界面数
	@Override
	public int getCount() {
		return pageViews.size();
	}

	//初始化position位置的界面
	@Override
	public Object instantiateItem(ViewGroup v, int position) {
		v.addView(pageViews.get(position));
        return pageViews.get(position);  
	}

	// 判断是否由对象生成界面
	@Override
	public boolean isViewFromObject(View v, Object arg1) {
		return v == arg1;
	}

	@Override
	public void startUpdate(View arg0) {
	}

	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}
}
