package com.dreamlayer.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.dto.InventoryResponse;
import com.dreamlayer.api.repository.InventoryRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	@SneakyThrows
	@Transactional(readOnly = true)
	public CommonResponse isInStock(List<String> skuCode) {
		
		List<InventoryResponse> result = inventoryRepository.findBySkuCodeIn(skuCode).stream()
														.map(inventory -> 
															InventoryResponse.builder()
																.skuCode(inventory.getSkuCode())
																.isInStock(inventory.getQuantity() > 0)
																.build()
														).toList();
		
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setStatus("Success");
		commonResponse.setStatus_code(00);
		commonResponse.setStatus_description("Successfully received InStock value");
		commonResponse.setResponse(result);
		return commonResponse;	
	}
}
