package com.idosinchuk.reactiveprogramming.microservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "insurancecompany-service")
public interface InsuranceFeignClient {

	@GetMapping("/products/{productCode}")
	public ResponseEntity<?> getProducts(@PathVariable(name = "productCode") String productCode);

}