package com.dreamlayer.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.dto.InventoryResponse;
import com.dreamlayer.api.manage.IInventoryManage;
import com.dreamlayer.api.service.IInventoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InventoryService implements IInventoryService {

	@Autowired
	private IInventoryManage iInventoryManage;
	
	@Override
	public CommonResponse isInStock(List<String> skuCode) {
		
		List<InventoryResponse> result = iInventoryManage.isInStock(skuCode).stream()
														.map(inventory -> 
															InventoryResponse.builder()
																.skuCode(inventory.getSkuCode())
																.isInStock(inventory.getQuantity() > 0)
																.build()
														).toList();
		
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setStatus("Success");
		commonResponse.setStatus_code(00);
		commonResponse.setTitle("Inventory Details");
		commonResponse.setMessage("Successfully received InStock value");
		commonResponse.setResponse(result);
		return commonResponse;	
	}
}
