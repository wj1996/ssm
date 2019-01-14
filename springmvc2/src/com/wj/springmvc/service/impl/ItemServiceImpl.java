package com.wj.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wj.springmvc.mapper.ItemMapper;
import com.wj.springmvc.pojo.Item;
import com.wj.springmvc.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService{

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> getItemList() {
		return itemMapper.selectByExample(null);
	}

	@Override
	public Item getItemById(Integer id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateItem(Item item) {
		itemMapper.updateByPrimaryKeySelective(item);
	}
	
	
}
