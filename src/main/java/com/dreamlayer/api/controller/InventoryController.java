package com.dreamlayer.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.service.impl.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.dreamlayer.api.utils.Constants.RequestMappings.INVENTORY;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(INVENTORY)
public class InventoryController {

	private final InventoryService inventoryService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> isInStock(@RequestParam List<String> skuCode) {
		
		log.info("Received inventory check request for skuCode: {}", skuCode);
		return ResponseEntity.ok(inventoryService.isInStock(skuCode));
	}
	
}
