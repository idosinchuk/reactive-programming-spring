package com.idosinchuk.reactiveprogramming.microservice.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public interface ReactiveService {

//	public Mono<String> hola() {
//		return Mono.just("hola asincrono").delayElement(Duration.ofSeconds(3));
//	}
//
//	public Mono<String> hola2() {
//
//		return Mono.just("hola asincrono").delayElement(Duration.ofSeconds(3));
//	}

	/**
	 * Find product by the id.
	 * 
	 * @param productCode product code
	 * @return {@link ProductResponseDTO}
	 */
	Mono<String> getProduct(String productCode);
}