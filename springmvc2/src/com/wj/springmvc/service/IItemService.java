package com.wj.springmvc.service;

import java.util.List;

import com.wj.springmvc.pojo.Item;

public interface IItemService {

	List<Item> getItemList();
	
	Item getItemById(Integer id);
	
	void updateItem(Item item);
}
