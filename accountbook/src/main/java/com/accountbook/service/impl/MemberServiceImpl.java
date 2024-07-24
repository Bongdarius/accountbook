package com.accountbook.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.accountbook.entity.Member;
import com.accountbook.repository.MemberRepository;
import com.accountbook.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	private final MemberRepository repository;
	
	@Override
	public Member selectOne(Member entity) {
		return null;
	}

	@Override
	public List<Member> selectList(Member entity) {
		return repository.findAll();
	}

	@Override
	public Member insertOne(Member entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> insertList(List<Member> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateOne(Member entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> updateList(List<Member> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOne(Member entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteList(List<Member> entityList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member> initDatas() throws Exception {
		List<Member> memberList = new ArrayList<>();
		Member member = new Member();
		
		String password = "1234";
		
		member.setMbId("admin");
		member.setMbPassword(passwordEncoder.encode(password));
		member.setMbNick("최고관리자");
//		member.setRegUserId(1);
//		member.setRegDt(LocalDateTime.now());
		memberList.add(repository.save(member));
		
		return memberList;
	}

	@Override
	public Member login(Member member) throws Exception {
		String password = member.getMbPassword();
		
		Member resultMember = repository.findByMbId(member.getMbId());
		
		String encryptedPassword = resultMember.getMbPassword();
		
		boolean checkPw = passwordEncoder.matches(password, encryptedPassword);
		
		if(checkPw) {
			return resultMember;
		} else {
			return null;
		}
	}

}
