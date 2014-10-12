package com.example.smartcommunity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.smartcommunity.neighcenter.NeighCenter;
import com.example.smartcommunity.payment.PaymentCenter;
import com.example.smartcommunity.ui.DragGridAdapter;
import com.example.smartcommunity.ui.DragGridView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * @blog http://blog.csdn.net/xiaanming 
 * @author xiaanming
 */
public class MainActivity extends Activity {
	
	private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();
	private static String[] labels = {"��������", "���ܼҾ�", "�����Ͳ�", "����ɷ�", 
										"�����Ź�", "����", "�����Ϣ", "���ó�ֵ", 
										"��Ʊ��Ѷ", "��������", "һ������", "�������",
										"ҽԺ����", "��ϴ����", "һ����", "������",
										"��������", "��ͥ���", "Я��Ʊ��", "���ó�ֵ",
										"���Ϲ���", "���ٱ���", "������Ѷ", "��װ����"
										};
	private static String[] images = {"icon_neighbourhood", "pic", "icon_eleme", "icon_payment", 
										"icon_meituan", "icon_tongquwang", "icon_kuaidi100", "pic", 
										"pic", "pic", "pic", "pic",
										"pic", "pic", "icon_dididache", "icon_damai",
										"pic", "pic", "pic", "pic",
										"pic", "pic", "pic", "pic"
										};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
		for (int i = 0; i < labels.length; i++) {
			HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
			itemHashMap.put("item_image", getDrawableRes(images[i]));
			itemHashMap.put("item_text", labels[i]);
			dataSourceList.add(itemHashMap);
		}
		
		final DragGridAdapter mDragAdapter = new DragGridAdapter(this, dataSourceList);
		
		mDragGridView.setAdapter(mDragAdapter);
		mDragGridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long rowid) {
				HashMap<String, Object> item = (HashMap<String, Object>)parent.getItemAtPosition(position);
				//String text = (String)item.get("item_text");
				int image = (Integer)item.get("item_image");
				//Toast.makeText(MainActivity.this, "δ��װ�˳���", Toast.LENGTH_LONG).show();
				switch (image) {
				case R.drawable.icon_eleme:
					Intent eleme=new Intent();    
					eleme.setClassName("me.ele", "me.ele.activity.SplashActivity");  
					try {
						startActivity(eleme);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "���Ȱ�װ����ô��", Toast.LENGTH_SHORT).show();
					}
					break;
					
				case R.drawable.icon_meituan:
					Intent meituan=new Intent();    
					meituan.setClassName("com.sankuai.meituan", "com.sankuai.meituan.activity.Welcome");
					try {
						startActivity(meituan);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "���Ȱ�װ����", Toast.LENGTH_SHORT).show();
					}
					break;
					
				case R.drawable.icon_tongquwang:
					Intent tongquwang=new Intent();    
					tongquwang.setClassName("com.tongqu", "com.tongqu.welcome.WelcomeActivity"); 
					try {
						startActivity(tongquwang);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "���Ȱ�װͬȥ�ͻ���", Toast.LENGTH_SHORT).show();
					}
					break;
					
				case R.drawable.icon_kuaidi100:
					Intent intent=new Intent();    
					intent.setClassName("com.Kingdee.Express", "com.Express.Activity.Splash");
					try {
						startActivity(intent);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "���Ȱ�װ���100", Toast.LENGTH_SHORT).show();
					}
					break;
					
				case R.drawable.icon_dididache:
					Intent dididache=new Intent();    
					dididache.setClassName("com.sdu.didi.psnger", "com.didi.frame.MainActivity");  
					try {
						startActivity(dididache);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "���Ȱ�װ�εδ�", Toast.LENGTH_SHORT).show();
					}
					break;
					
				case R.drawable.icon_damai:
					Intent damai=new Intent();    
					damai.setClassName("cn.damai", "cn.damai.activity.MainSplashActivity");  
					try {
						startActivity(damai);
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "���Ȱ�װ����ͻ���", Toast.LENGTH_SHORT).show();
					}
					break;
					
				case R.drawable.icon_neighbourhood:
					Intent neighCenterIntent = new Intent(MainActivity.this, NeighCenter.class);
					startActivity(neighCenterIntent);
					break;
					
				case R.drawable.icon_payment:
					Intent paymentIntent = new Intent(MainActivity.this,PaymentCenter.class);
					startActivity(paymentIntent);
					break;
					
				default:
					break;
				}
			}
		});
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

