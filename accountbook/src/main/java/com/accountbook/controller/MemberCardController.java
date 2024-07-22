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
import com.accountbook.entity.Member;
import com.accountbook.entity.MemberCard;
import com.accountbook.service.MemberCardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/memberCard")
@RequiredArgsConstructor
public class MemberCardController {
	
	private final MemberCardService service;
	
	@PostMapping("/initDatas")
	public ResponseEntity<List<MemberCard>> initDatas() throws Exception {
		
		ResponseEntity<List<MemberCard>> MemberCardList = Optional.ofNullable(service.initDatas())
															.map(list -> ResponseEntity.ok(list))
															.orElse(ResponseEntity.noContent().build());
			
		return MemberCardList;
	}
	
	@GetMapping("/{mbSeq}/{cardSeq}")
	public ResponseEntity<MemberCard> selectOne(@PathVariable Integer mbSeq, @PathVariable Integer cardSeq) throws Exception {
		Member member = new Member();
		Card card = new Card();
		
		member.setMbSeq(mbSeq);
		card.setCardSeq(cardSeq);
		
		return Optional.ofNullable(service.selectOne(member, card))
				.map(list -> ResponseEntity.ok(list))
				.orElse(ResponseEntity.noContent().build());
	}
}
