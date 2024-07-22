package com.accountbook.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accountbook.entity.Card;
import com.accountbook.repository.CardRepository;
import com.accountbook.service.CardService;

import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

	private final CardRepository repository;
		
	@Override
	public Card selectOne(Card card) {
		return repository.findById(card.getCardSeq()).get();
	}

	@Override
	public List<Card> selectList(Card card) {
		return repository.findAll();
	}

	@Override
	public Card insertOne(Card entity) {
		return null;
	}

	@Override
	public List<Card> insertList(List<Card> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card updateOne(Card entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> updateList(List<Card> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOne(Card entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteList(List<Card> entityList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Card> initDatas() throws Exception {
		List<Card> cardList = new ArrayList<>();
		
		List<String> cardNmList = new ArrayList<>();
//		cardNmList.add("KB국민은행");
//		cardNmList.add("카카오뱅크");
//		cardNmList.add("농협중앙회");
//		cardNmList.add("지역농협");
//		cardNmList.add("IBK기업은행");
//		cardNmList.add("우리은행");
//		cardNmList.add("토스뱅크");
//		cardNmList.add("하나은행");
//		cardNmList.add("부산은행");
//		cardNmList.add("경남은행");
//		cardNmList.add("광주은행");
//		cardNmList.add("제주은행");
//		cardNmList.add("현대");
//		cardNmList.add("삼성");
//		cardNmList.add("LG");
//		cardNmList.add("BC");
//		cardNmList.add("신협");
//		cardNmList.add("기타");
		
		for(String cardNm : cardNmList) {
			Card card = new Card();
			card.setCardNm(cardNm);
			card.setRegUserId(1);
			card.setRegDt(LocalDateTime.now());
			repository.save(card);
			cardList.add(card);
		}
		
		return cardList;
	}

}
