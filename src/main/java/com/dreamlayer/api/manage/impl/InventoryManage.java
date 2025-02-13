package com.dreamlayer.api.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamlayer.api.manage.IInventoryManage;
import com.dreamlayer.api.modal.Inventory;
import com.dreamlayer.api.repository.InventoryRepository;

@Component
public class InventoryManage implements IInventoryManage {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public List<Inventory> isInStock(List<String> skuCode) {
		
		 return inventoryRepository.findBySkuCodeIn(skuCode);
	}

}
