package com.example.smartcommunity.ui;

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

public class PaymentCenter extends Activity {
	//icon
	private Integer[] mFuncIcon = {R.drawable.icon_water,R.drawable.icon_power,R.drawable.icon_gas,
			R.drawable.icon_dongfang,R.drawable.icon_chinamobile,R.drawable.icon_chinaunicom,R.drawable.icon_chinatelecom};
	private Integer[] mFuncLab = {R.string.lab_waterbill,R.string.lab_powerbill,R.string.lab_gasbill,
			R.string.lab_dongfangcable,R.string.lab_chinamobile,R.string.lab_chinaunicom,R.string.lab_chinatelecom};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_payment_center);
		
		GridView pcGridView = (GridView)findViewById(R.id.paymentcenter);
		ArrayList<HashMap<String, Object>> lstItem = new ArrayList<HashMap<String,Object>>();
		for (int i = 0; i < mFuncIcon.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("icon", mFuncIcon[i]);
			map.put("lab", (String)this.getResources().getText(mFuncLab[i]));
			lstItem.add(map);
		}
		
		SimpleAdapter gridAdapter = new SimpleAdapter(
				this, lstItem, R.layout.payment_item,
				new String[]{"icon","lab"}, new int[]{R.id.pc_func_item_icon,R.id.pc_func_item_lab});
		
		pcGridView.setAdapter(gridAdapter);
		pcGridView.setOnItemClickListener(new PaymentItemListener());
	}

	class PaymentItemListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int position,
				long rowid) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "payment center", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.payment_center, menu);
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
