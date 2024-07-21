package com.accountbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountbook.entity.Card;
import com.accountbook.service.CardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/card")
@RequiredArgsConstructor
public class CardController {

	private final CardService service;
	
	@PostMapping("/initDatas")
	public ResponseEntity<List<Card>> initDatas() throws Exception {
		
		return Optional.ofNullable(service.initDatas())
				.map(list -> ResponseEntity.ok(list))
				.orElse(ResponseEntity.noContent().build());
	}
}