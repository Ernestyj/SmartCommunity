package com.example.smartcommunity.ui;

public interface DragGridAdapterBase {
	/**
	 * 重新排列数据
	 * @param oldPosition
	 * @param newPosition
	 */
	public void reorderItems(int oldPosition, int newPosition);
	
	
	/**
	 * 设置某个item隐藏
	 * @param hidePosition
	 */
	public void setHideItem(int hidePosition);
	

}
