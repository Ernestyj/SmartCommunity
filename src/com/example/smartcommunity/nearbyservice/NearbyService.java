package com.example.smartcommunity.nearbyservice;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.smartcommunity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class NearbyService extends Activity {
	
	//icon
	private Integer[] mFuncIcon = {R.drawable.icon_clinic, R.drawable.icon_massage, 
								R.drawable.icon_training, R.drawable.icon_nursery, 
								R.drawable.icon_logistics, R.drawable.icon_laundry, 
								R.drawable.icon_travelagent };
	//label
	private String[] mFuncLab = {"诊所", "按摩", "培训班", "托儿所", 
								"物流", "洗衣", "旅行社"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_nearby_service);
		
		GridView ncGridView = (GridView)findViewById(R.id.nearbyservice);
		ArrayList<HashMap<String, Object>> lstItem = new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < mFuncIcon.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("icon", mFuncIcon[i]);
			map.put("lab",mFuncLab[i]);
			lstItem.add(map);
		}
		
		SimpleAdapter gridAdapter = new SimpleAdapter(
				this,lstItem,R.layout.nearbyservice_item,
				new String[]{"icon","lab"},new int[]{R.id.ns_func_item_icon,R.id.ns_func_item_lab});
		
		ncGridView.setAdapter(gridAdapter);
		ncGridView.setOnItemClickListener(new ItemClickListener());
	}

	class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int position,
				long rowid) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "listening", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.neigh_center, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
