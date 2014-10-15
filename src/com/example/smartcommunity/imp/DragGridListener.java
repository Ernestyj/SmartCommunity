package com.example.smartcommunity.imp;

import java.util.HashMap;

import com.example.smartcommunity.R;
import com.example.smartcommunity.nearbyservice.NearbyService;
import com.example.smartcommunity.neighcenter.NeighCenter;
import com.example.smartcommunity.payment.PaymentCenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DragGridListener implements OnItemClickListener {
	private Activity activity;
	
	public DragGridListener(Activity act) {
		// TODO Auto-generated constructor stub
		activity = act;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long rowid) {
		HashMap<String, Object> item = (HashMap<String, Object>)parent.getItemAtPosition(position);
		int image = (Integer)item.get("item_image");		
		switch (image) {
		case R.drawable.icon_eleme:
			Intent eleme=new Intent();    
			eleme.setClassName("me.ele", "me.ele.activity.SplashActivity");  
			try {
				activity.startActivity(eleme);
			} catch (Exception e) {
				Toast.makeText(activity.getApplicationContext(), "请先安装饿了么", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.drawable.icon_meituan:
			Intent meituan=new Intent();    
			meituan.setClassName("com.sankuai.meituan", "com.sankuai.meituan.activity.Welcome");
			try {
				activity.startActivity(meituan);
			} catch (Exception e) {
				Toast.makeText(activity.getApplicationContext(), "请先安装美团", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.drawable.icon_tongquwang:
			Intent tongquwang=new Intent();    
			tongquwang.setClassName("com.tongqu", "com.tongqu.welcome.WelcomeActivity"); 
			try {
				activity.startActivity(tongquwang);
			} catch (Exception e) {
				Toast.makeText(activity.getApplicationContext(), "请先安装同去客户端", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.drawable.icon_kuaidi100:
			Intent intent=new Intent();    
			intent.setClassName("com.Kingdee.Express", "com.Express.Activity.Splash");
			try {
				activity.startActivity(intent);
			} catch (Exception e) {
				Toast.makeText(activity.getApplicationContext(), "请先安装快递100", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.drawable.icon_dididache:
			Intent dididache=new Intent();    
			dididache.setClassName("com.sdu.didi.psnger", "com.didi.frame.MainActivity");  
			try {
				activity.startActivity(dididache);
			} catch (Exception e) {
				Toast.makeText(activity.getApplicationContext(), "请先安装滴滴打车", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.drawable.icon_damai:
			Intent damai=new Intent();    
			damai.setClassName("cn.damai", "cn.damai.activity.MainSplashActivity");  
			try {
				activity.startActivity(damai);
			} catch (Exception e) {
				Toast.makeText(activity.getApplicationContext(), "请先安装大麦客户端", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.drawable.icon_neighbourhood:
			Intent neighCenterIntent = new Intent(activity.getApplicationContext(), NeighCenter.class);
			activity.startActivity(neighCenterIntent);
			break;
			
		case R.drawable.icon_payment:
			Intent paymentIntent = new Intent(activity.getApplicationContext(),PaymentCenter.class);
			activity.startActivity(paymentIntent);
			break;
			
		case R.drawable.icon_nearbyservice:
			Intent nearbyServiceIntent = new Intent(activity.getApplicationContext(),NearbyService.class);
			activity.startActivity(nearbyServiceIntent);
			break;
			
		default:
			break;
		}
	}
}
