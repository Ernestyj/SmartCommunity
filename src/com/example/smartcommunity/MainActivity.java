package com.example.smartcommunity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;

import com.example.smartcommunity.imp.DragGridListener;
import com.example.smartcommunity.imp.ViewPagerAdapter;
import com.example.smartcommunity.imp.ViewPagerChangeListener;
import com.example.smartcommunity.view.DragGridAdapter;
import com.example.smartcommunity.view.DragGridView;

public class MainActivity extends Activity {
	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	/** 装分页显示的view的数组 */
	private ImageView pointImageView;
	private ImageView[] pointImageViews;
	/** 将小圆点的图片用数组表示 */
	private ViewGroup mainGroup;// 包裹滑动图片的LinearLayout
	private ViewGroup pointGroup;// 包裹小圆点的LinearLayout
	private List<HashMap<String, Object>> dataSourceList1 = new ArrayList<HashMap<String, Object>>();
	private List<HashMap<String, Object>> dataSourceList2 = new ArrayList<HashMap<String, Object>>();
	private List<HashMap<String, Object>> dataSourceList3 = new ArrayList<HashMap<String, Object>>();

	private static String[] labels = { "周边服务", "邻里中心", "智能家居", "社区送餐", "便民缴费",
			"邻里团购", "邻里活动", "快递信息", "费用充值", "彩票资讯", 
			"紧急呼救", "一键家政", "老年服务", "医院服务", "干洗服务", 
			"一键打车", "格瓦拉", "自助银行", "家庭理财", "携程票务", 
			"网上购物", "人寿保险", "亲子资讯", "家装服务" };
	private static String[] images = { "icon_nearbyservice", "icon_neighbourhood", "icon_smarthome", "icon_eleme", "icon_payment", 
		"icon_meituan", "icon_tongquwang", "icon_kuaidi100", "icon_recharge", "icon_lottery", 
		"icon_emergency", "icon_clean", "icon_elder", "icon_hospital", "icon_drycleaning", 
		"icon_dididache", "icon_damai", "icon_bank", "icon_finance", "icon_travel", 
		"icon_shopping", "icon_insurance", "icon_baby", "icon_fix" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initView();
	}

	private int getDrawableRes(String s) {
		try {
			Field field = R.drawable.class.getField(s);
			int i = field.getInt(new R.drawable());
			return i;
		} catch (Exception e) {
			return -1;
		}
	}

	private void initView() {
		LayoutInflater inflater = getLayoutInflater();
		mainGroup = (ViewGroup) inflater.inflate(R.layout.activity_main, null);

		// 将要分页显示的View装入数组中
		pageViews = new ArrayList<View>();

		View view1 = inflater.inflate(R.layout.drag_grid_view_page1, null);
		View view2 = inflater.inflate(R.layout.drag_grid_view_page2, null);
		View view3 = inflater.inflate(R.layout.drag_grid_view_page3, null);
		pageViews.add(view1);
		pageViews.add(view2);
		pageViews.add(view3);

		DragGridView mDragGridView1 = (DragGridView) view1
				.findViewById(R.id.dragGridView1);
		DragGridView mDragGridView2 = (DragGridView) view2
				.findViewById(R.id.dragGridView2);
		DragGridView mDragGridView3 = (DragGridView) view3
				.findViewById(R.id.dragGridView3);

		for (int i = 0; i < labels.length; i++) {
			HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
			itemHashMap.put("item_image", getDrawableRes(images[i]));
			itemHashMap.put("item_text", labels[i]);
			switch (i % 3) {
			case 0:
				dataSourceList1.add(itemHashMap);
				break;

			case 1:
				dataSourceList2.add(itemHashMap);
				break;

			case 2:
				dataSourceList3.add(itemHashMap);
				break;

			default:
				break;
			}

		}
		DragGridAdapter mDragAdapter1 = new DragGridAdapter(this,
				dataSourceList1);
		mDragGridView1.setAdapter(mDragAdapter1);
		mDragGridView1.setOnItemClickListener(new DragGridListener(this));

		DragGridAdapter mDragAdapter2 = new DragGridAdapter(this,
				dataSourceList2);
		mDragGridView2.setAdapter(mDragAdapter2);
		mDragGridView2.setOnItemClickListener(new DragGridListener(this));

		DragGridAdapter mDragAdapter3 = new DragGridAdapter(this,
				dataSourceList3);
		mDragGridView3.setAdapter(mDragAdapter3);
		mDragGridView3.setOnItemClickListener(new DragGridListener(this));

		// 实例化小圆点的linearLayout和viewpager
		pointGroup = (ViewGroup) mainGroup.findViewById(R.id.pointGroup);
		viewPager = (ViewPager) mainGroup.findViewById(R.id.viewPager);

		// 创建imageviews数组，大小是要显示的图片的数量
		pointImageViews = new ImageView[pageViews.size()];
		// 添加小圆点的图片
		for (int i = 0; i < pageViews.size(); i++) {
			pointImageView = new ImageView(MainActivity.this);
			// 设置小圆点imageview的参数
			pointImageView.setLayoutParams(new LayoutParams(20, 20));// 创建一个宽高均为20
																		// 的布局
			pointImageView.setPadding(20, 0, 20, 0);
			// 将小圆点layout添加到数组中
			pointImageViews[i] = pointImageView;
			// 默认选中的是第一张图片，此时第一个小圆点是选中状态，其他不是
			if (i == 0) {
				pointImageViews[i]
						.setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				pointImageViews[i]
						.setBackgroundResource(R.drawable.page_indicator);
			}
			// 将imageviews添加到小圆点视图组
			pointGroup.addView(pointImageViews[i]);
		}

		// 显示滑动图片的视图
		setContentView(mainGroup);

		// 设置viewpager的适配器和监听事件
		viewPager.setAdapter(new ViewPagerAdapter(pageViews));
		viewPager.setOnPageChangeListener(new ViewPagerChangeListener(
				pointImageViews));
	}
}
