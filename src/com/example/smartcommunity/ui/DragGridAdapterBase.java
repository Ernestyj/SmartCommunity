package com.example.smartcommunity.ui;

public interface DragGridAdapterBase {
	/**
	 * ������������
	 * @param oldPosition
	 * @param newPosition
	 */
	public void reorderItems(int oldPosition, int newPosition);
	
	
	/**
	 * ����ĳ��item����
	 * @param hidePosition
	 */
	public void setHideItem(int hidePosition);
	

}
