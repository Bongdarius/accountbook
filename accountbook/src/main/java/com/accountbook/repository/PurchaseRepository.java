package com.accountbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountbook.entity.Member;
import com.accountbook.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
	List<Purchase> findByMemberOrderByPcDatetimeDesc(Member member);
}
