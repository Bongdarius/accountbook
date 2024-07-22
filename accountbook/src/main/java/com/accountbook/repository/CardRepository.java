package com.accountbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountbook.entity.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
