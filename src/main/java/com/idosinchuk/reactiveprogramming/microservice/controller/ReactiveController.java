package com.idosinchuk.reactiveprogramming.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idosinchuk.reactiveprogramming.microservice.feign.InsuranceFeignClient;
import com.idosinchuk.reactiveprogramming.microservice.service.ReactiveService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "API Rest for reactiv programming.")
@RequestMapping(value = "/api/v1")
public class ReactiveController {

	public static final Logger logger = LoggerFactory.getLogger(ReactiveController.class);

	@Autowired
	InsuranceFeignClient insuranceFeignClient;

	@Autowired
	ReactiveService reactiveService;

	/**
	 * Retrieve products and actors by the productCode.
	 * 
	 * @param productCode product code
	 * @return
	 */
	@ResponseBody
	@GetMapping(path = "/reactive/{productCode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve results using reactivity")
	public Flux<String> getProducts(@PathVariable("productCode") String productCode) {

		// Mono<String> mono1 = reactivService.hola();
		// Mono<String> mono2 = reactivService.hola2();

		// Flux<String> flujo = Flux.concat(mono1, mono2);

		// return flujo;
		logger.error("An error occurred!");
		ResponseEntity<?> response = insuranceFeignClient.getProducts(productCode);
		Mono<String> mono1 = reactiveService.getProduct(productCode);
		Mono<String> mono2 = Mono.just("hola2");

		Flux<String> flujo = Flux.concat(mono1, mono2);

		return flujo;

	}
}
