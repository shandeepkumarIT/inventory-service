package com.dreamlayer.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.service.InventoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_200_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_200_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_400_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_400_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_401_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_401_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_403_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_403_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_404_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_404_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_429_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_429_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_500_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_500_MESSAGE;

import static com.dreamlayer.api.utils.Constants.RequestMappings.INVENTORY;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(INVENTORY)
@Api(value = INVENTORY)
public class InventoryController {

	private final InventoryService inventoryService;
	
	@ReadOperation
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "isInStock")
	@ApiResponses(value = {
			@ApiResponse(code = HTTP_200_CODE, message = HTTP_200_MESSAGE, response = CommonResponse.class),
			@ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
			@ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
			@ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
			@ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
			@ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
			@ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE) })
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> isInStock(@RequestParam List<String> skuCode) {
		
		log.info("Received inventory check request for skuCode: {}", skuCode);
		return ResponseEntity.ok(inventoryService.isInStock(skuCode));
	}
	
}
