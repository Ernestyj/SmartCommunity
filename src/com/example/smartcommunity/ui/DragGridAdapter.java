package com.example.smartcommunity.ui;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.example.smartcommunity.R;
import com.example.smartcommunity.ui.DragGridAdapterBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * @blog http://blog.csdn.net/xiaanming 
 * 
 * @author xiaanming
 *
 */
public class DragGridAdapter extends BaseAdapter implements DragGridAdapterBase{
	private List<HashMap<String, Object>> list;
	private LayoutInflater mInflater;
	private int mHidePosition = -1;
	
	public DragGridAdapter(Context context, List<HashMap<String, Object>> list){
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * ���ڸ���convertView����ĳЩitem��ʧ�ˣ��������ﲻ����item��
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(R.layout.grid_item, null);
		ImageView mImageView = (ImageView) convertView.findViewById(R.id.item_image);
		TextView mTextView = (TextView) convertView.findViewById(R.id.item_text);
		
		mImageView.setImageResource((Integer) list.get(position).get("item_image"));
		mTextView.setText((CharSequence) list.get(position).get("item_text"));
		
		if(position == mHidePosition){
			convertView.setVisibility(View.INVISIBLE);
		}
		
		return convertView;
	}
	

	@Override
	public void reorderItems(int oldPosition, int newPosition) {
		HashMap<String, Object> temp = list.get(oldPosition);
		if(oldPosition < newPosition){
			for(int i=oldPosition; i<newPosition; i++){
				Collections.swap(list, i, i+1);
			}
		}else if(oldPosition > newPosition){
			for(int i=oldPosition; i>newPosition; i--){
				Collections.swap(list, i, i-1);
			}
		}
		
		list.set(newPosition, temp);
	}

	@Override
	public void setHideItem(int hidePosition) {
		this.mHidePosition = hidePosition; 
		notifyDataSetChanged();
	}


}
