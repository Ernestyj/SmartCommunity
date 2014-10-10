package com.example.smartcommunity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.smartcommunity.ui.DragGridAdapter;
import com.example.smartcommunity.ui.DragGridView;

import android.app.Activity;
import android.os.Bundle;

/**
 * @blog http://blog.csdn.net/xiaanming 
 * 
 * @author xiaanming
 *
 */
public class MainActivity extends Activity {
	
	private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();
	private static String[] imageNames = {"邻里中心", "智能家居", "社区送餐", "便民缴费", 
										"邻里团购", "邻里活动", "快递信息", "费用充值", 
										"彩票资讯", "紧急呼救", "一键家政", "老年服务",
										"医院服务", "干洗服务", "一键打车", "格瓦拉",
										"自助银行", "家庭理财", "携程票务", "费用充值",
										"网上购物", "人寿保险", "亲子资讯", "家装服务"
										};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
		for (int i = 0; i < imageNames.length; i++) {
			HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
			itemHashMap.put("item_image",R.drawable.com_tencent_open_notice_msg_icon_big);
			itemHashMap.put("item_text", imageNames[i]);
			dataSourceList.add(itemHashMap);
		}
		
		final DragGridAdapter mDragAdapter = new DragGridAdapter(this, dataSourceList);
		
		mDragGridView.setAdapter(mDragAdapter);
	}
	
	private int getResId(String s){
		try {
			Field field = R.drawable.class.getField(s);
			int i = field.getInt(new R.drawable());
			return i;
		} catch (Exception e) {
			return -1;
		}
	}

}

