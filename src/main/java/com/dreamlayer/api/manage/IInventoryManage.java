package com.dreamlayer.api.manage;

import java.util.List;

import com.dreamlayer.api.modal.Inventory;

public interface IInventoryManage {

	public List<Inventory> isInStock(List<String> skuCode);
}
