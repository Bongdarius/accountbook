package com.accountbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accountbook.entity.Card;
import com.accountbook.entity.Member;
import com.accountbook.entity.MemberCard;
import com.accountbook.repository.CardRepository;
import com.accountbook.repository.MemberCardRepository;
import com.accountbook.repository.MemberRepository;
import com.accountbook.service.MemberCardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberCardServiceImpl implements MemberCardService {

	private final MemberCardRepository repository;
	private final MemberRepository memberRepository; 
	private final CardRepository cardRepository; 
	
	@Override
	public MemberCard selectOne(MemberCard entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberCard> selectList(MemberCard entity) {
		return repository.findByMember(entity.getMember());
	}

	@Override
	public MemberCard insertOne(MemberCard entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberCard> insertList(List<MemberCard> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberCard updateOne(MemberCard entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberCard> updateList(List<MemberCard> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOne(MemberCard entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteList(List<MemberCard> entityList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberCard> initDatas() throws Exception {
		List<MemberCard> memberCardList = new ArrayList<>();
		
		List<Card> cardList = cardRepository.findAll();
		Member member = memberRepository.findByMbId("admin");
		
		for(Card card : cardList) {
			MemberCard memberCard = new MemberCard();
			memberCard.setCard(card);
			memberCard.setMember(member);
			memberCardList.add(repository.save(memberCard));
		}
		
		return memberCardList;
	}

	@Override
	public MemberCard selectOne(Member member, Card card) {
		return repository.findByMemberAndCard(member, card);
	}
		
	

}
