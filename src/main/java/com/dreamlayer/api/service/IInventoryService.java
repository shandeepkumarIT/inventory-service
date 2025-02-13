package com.dreamlayer.api.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dreamlayer.api.dto.CommonResponse;

public interface IInventoryService {

	@Transactional(readOnly = true)
	public CommonResponse isInStock(List<String> skuCode);
}
