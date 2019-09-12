package com.idosinchuk.reactiveprogramming.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.idosinchuk.reactiveprogramming.microservice.feign.InsuranceFeignClient;
import com.idosinchuk.reactiveprogramming.microservice.service.ReactiveService;

import reactor.core.publisher.Mono;

@Service
public class ReactiveServiceImpl implements ReactiveService {

	@Autowired
	InsuranceFeignClient insuranceFeignClient;

	/**
	 * {@inheritDoc}
	 */
	public Mono<String> getProduct(String productCode) {

		ResponseEntity<?> insuranceProducts = insuranceFeignClient.getProducts(productCode);
		insuranceProducts.getStatusCode();
		return Mono.just("hola");
	}
}