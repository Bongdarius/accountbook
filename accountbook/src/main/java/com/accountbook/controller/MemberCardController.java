package com.accountbook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountbook.dto.MemberCardDto;
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
		
		ResponseEntity<List<MemberCard>> memberCardList = Optional.ofNullable(service.initDatas())
															.map(list -> ResponseEntity.ok(list))
															.orElse(ResponseEntity.noContent().build());
		return memberCardList;
	}
	
	@GetMapping("/{mbSeq}/{cardSeq}")
	public ResponseEntity<MemberCardDto> selectOne(@PathVariable Integer mbSeq, @PathVariable Integer cardSeq) throws Exception {
		Member member = new Member();
		Card card = new Card();
		
		member.setMbSeq(mbSeq);
		card.setCardSeq(cardSeq);
		
		MemberCardDto dto = service.selectOne(member, card).setDto();
		
		return Optional.ofNullable(dto)
				.map(list -> ResponseEntity.ok(list))
				.orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping("/{mbSeq}")
	public ResponseEntity<List<MemberCardDto>> selectList(@PathVariable Integer mbSeq) throws Exception {
		MemberCard memberCard = new MemberCard();
		Member member = new Member();
		member.setMbSeq(mbSeq);
		memberCard.setMember(member);
		
		List<MemberCard> list = service.selectList(memberCard);
		List<MemberCardDto> dtoList = new ArrayList<>();
		
		list.forEach(each -> dtoList.add(each.setDto()));
		
		return Optional.ofNullable(dtoList)
				.map(dtolist_ -> ResponseEntity.ok(dtolist_))
				.orElse(ResponseEntity.noContent().build());
	}
}
