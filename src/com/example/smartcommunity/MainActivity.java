package com.example.smartcommunity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.smartcommunity.imp.DragGridListener;
import com.example.smartcommunity.imp.ViewPagerAdapter;
import com.example.smartcommunity.imp.ViewPagerChangeListener;
import com.example.smartcommunity.nearbyservice.NearbyService;
import com.example.smartcommunity.neighcenter.NeighCenter;
import com.example.smartcommunity.payment.PaymentCenter;
import com.example.smartcommunity.view.DragGridAdapter;
import com.example.smartcommunity.view.DragGridView;

/**
 * @blog http://blog.csdn.net/xiaanming 
 * @author xiaanming
 */
public class MainActivity extends Activity {
	private ViewPager viewPager;
	private ArrayList<View> pageViews;/**装分页显示的view的数组*/
	private ImageView pointImageView;
	private ImageView[] pointImageViews;/**将小圆点的图片用数组表示*/
	private ViewGroup mainGroup;//包裹滑动图片的LinearLayout
	private ViewGroup pointGroup;//包裹小圆点的LinearLayout
	private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();
	private static String[] labels = {"周边服务", "邻里中心", "智能家居", "社区送餐", "便民缴费", 
										"邻里团购", "邻里活动", "快递信息", "费用充值", 
										"彩票资讯", "紧急呼救", "一键家政", "老年服务",
										"医院服务", "干洗服务", "一键打车", "格瓦拉",
										"自助银行", "家庭理财", "携程票务", "费用充值",
										"网上购物", "人寿保险", "亲子资讯", "家装服务"
										};
	private static String[] images = {"icon_nearbyservice", "icon_neighbourhood", "icon_smarthome", "icon_eleme", "icon_payment", 
										"icon_meituan", "icon_tongquwang", "icon_kuaidi100", "pic", 
										"pic", "pic", "pic", "pic",
										"pic", "pic", "icon_dididache", "icon_damai",
										"pic", "pic", "pic", "pic",
										"pic", "pic", "pic", "pic"
										};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		LayoutInflater inflater = getLayoutInflater();
		mainGroup = (ViewGroup) inflater.inflate(R.layout.activity_main, null);
		
		//将要分页显示的View装入数组中
        pageViews = new ArrayList<View>();
        
        View view1 = inflater.inflate(R.layout.drag_grid_view_page, null);
        View view2 = inflater.inflate(R.layout.page2, null);
        View view3 = inflater.inflate(R.layout.page3, null);
        pageViews.add(view1);
        pageViews.add(view2);
        pageViews.add(view3);
		
		DragGridView mDragGridView = (DragGridView) view1.findViewById(R.id.dragGridView);
		
		for (int i = 0; i < labels.length; i++) {
			HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
			itemHashMap.put("item_image", getDrawableRes(images[i]));
			itemHashMap.put("item_text", labels[i]);
			dataSourceList.add(itemHashMap);
		}
		DragGridAdapter mDragAdapter = new DragGridAdapter(this, dataSourceList);
		mDragGridView.setAdapter(mDragAdapter);
		mDragGridView.setOnItemClickListener(new DragGridListener(this));
        
        //实例化小圆点的linearLayout和viewpager
        pointGroup = (ViewGroup) mainGroup.findViewById(R.id.pointGroup);
        viewPager = (ViewPager) mainGroup.findViewById(R.id.viewPager);
        
        //创建imageviews数组，大小是要显示的图片的数量
        pointImageViews = new ImageView[pageViews.size()];
        //添加小圆点的图片
        for(int i=0; i<pageViews.size(); i++){
        	pointImageView = new ImageView(MainActivity.this);
        	//设置小圆点imageview的参数
        	pointImageView.setLayoutParams(new LayoutParams(20,20));//创建一个宽高均为20 的布局
        	pointImageView.setPadding(20, 0, 20, 0);
        	//将小圆点layout添加到数组中
        	pointImageViews[i] = pointImageView;
        	//默认选中的是第一张图片，此时第一个小圆点是选中状态，其他不是
        	if(i==0){
        		pointImageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
        	}else{
        		pointImageViews[i].setBackgroundResource(R.drawable.page_indicator);
        	}
        	//将imageviews添加到小圆点视图组
        	pointGroup.addView(pointImageViews[i]);
        }
        
		//显示滑动图片的视图
        setContentView(mainGroup);
        
        //设置viewpager的适配器和监听事件
        viewPager.setAdapter(new ViewPagerAdapter(pageViews));
        viewPager.setOnPageChangeListener(new ViewPagerChangeListener(pointImageViews));
	}
	
	private int getDrawableRes(String s){
		try {
			Field field = R.drawable.class.getField(s);
			int i = field.getInt(new R.drawable());
			return i;
		} catch (Exception e) {
			return -1;
		}
	}
}

