package com.accountbook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accountbook.dto.MemberDto;
import com.accountbook.entity.Member;
import com.accountbook.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService service;
	
	@PostMapping("/initDatas")
	public ResponseEntity<List<Member>> initDatas() throws Exception {
		return Optional.ofNullable(service.initDatas())
				.map(list -> ResponseEntity.ok(list))
				.orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping
	public ResponseEntity<List<MemberDto>> selectList() throws Exception {
		List<MemberDto> dto = new ArrayList<>(); 
		List<Member> memberList = service.selectList(new Member());
		
		try {
			for(Member member : memberList) {
				dto.add(member.setDto());
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(memberList.size());
		}
	
		
		ResponseEntity<List<MemberDto>> returnMemberList = ResponseEntity.ok(dto);
		return returnMemberList;
	}
	
	@GetMapping("/login")
	public ResponseEntity<Member> login(@RequestParam String mbId, @RequestParam String mbPassword) throws Exception {
		Member member = new Member();
		member.setMbId(mbId);
		member.setMbPassword(mbPassword);
		Member loginMember = service.login(member);
		ResponseEntity<Member> returnMember = Optional.ofNullable(loginMember)
												.map(member_ -> ResponseEntity.ok(member_))
												.orElse(ResponseEntity.noContent().build());
		return returnMember;
	}
}
