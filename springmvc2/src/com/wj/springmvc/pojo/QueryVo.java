package com.wj.springmvc.pojo;

import java.util.List;

public class QueryVo {

	private Item item;
	private Integer[] ids;
	
	private List<Item> items;
	
	

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
	
	
}


