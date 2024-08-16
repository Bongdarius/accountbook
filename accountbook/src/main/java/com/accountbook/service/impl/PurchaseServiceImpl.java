package com.accountbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accountbook.entity.MemberCard;
import com.accountbook.entity.Purchase;
import com.accountbook.entity.PurchaseCard;
import com.accountbook.repository.PurchaseCardRepository;
import com.accountbook.repository.PurchaseRepository;
import com.accountbook.service.PurchaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
	
	private final PurchaseRepository repository;
	private final PurchaseCardRepository purchaseCardrepository;
	
	@Override
	public Purchase selectOne(Purchase entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> selectList(Purchase entity) {
		return repository.findByMemberOrderByPcDatetimeDesc(entity.getMember());
	}

	@Override
	public Purchase insertOne(Purchase entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> insertList(List<Purchase> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase updateOne(Purchase entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> updateList(List<Purchase> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> saveList(List<Purchase> entityList) {
		for(int i = 0; i < entityList.size(); i++) {
			PurchaseCard purchaseCard = new PurchaseCard();
			MemberCard memberCard = new MemberCard();
			
			Integer pcmSeq = entityList.get(i).getPurchaseMethod().getPcmSeq();
			if(pcmSeq != 1) continue;
			
			Integer mcSeq = entityList.get(i).getPurchaseCard().getMemberCard().getMcSeq();
			memberCard.setMcSeq(mcSeq);
			purchaseCard.setMemberCard(memberCard);
			entityList.get(i).setPurchaseCard(purchaseCardrepository.save(purchaseCard));
		}
		
		List<Purchase> list = new ArrayList<>();
		entityList.forEach(each -> list.add(repository.save(each)));
		return list;
	}

	@Override
	public void deleteOne(Purchase entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteList(List<Purchase> entityList) {
		entityList.forEach(each -> repository.deleteById(each.getPcSeq()));
	}
	
}
