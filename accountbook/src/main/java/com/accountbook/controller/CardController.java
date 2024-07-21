package com.accountbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping(value = "/initDatas")
	public ResponseEntity<List<Card>> initDatas() throws Exception {
		return Optional.ofNullable(service.initDatas())
				.map(list -> ResponseEntity.ok(list))
				.orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Card>> selectList() throws Exception {
		return Optional.ofNullable(service.selectList(new Card()))
				.map(list -> ResponseEntity.ok(list))
				.orElse(ResponseEntity.noContent().build());
	} 
	
	@GetMapping(value = "/{seq}")
	public ResponseEntity<Card> selectOne(@PathVariable Integer seq) throws Exception {

		Card card = new Card();
		card.setCardSeq(seq);
		
		return Optional.ofNullable(service.selectOne(card))
				.map(card_ -> ResponseEntity.ok(card_))
				.orElse(ResponseEntity.noContent().build());
	} 
}