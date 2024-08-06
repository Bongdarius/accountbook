package com.accountbook.entity;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.accountbook.dto.MemberCardDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member_card")
public class MemberCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mc_seq_generator")
    @SequenceGenerator(name = "mc_seq_generator", sequenceName = "mc_seq", allocationSize = 1)
    @ColumnDefault("nextval('mc_seq'::regclass)")
    private Integer mcSeq;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "mb_seq", nullable = false)
    private Member member;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "card_seq", nullable = false)
    private Card card; 
    
    @OneToMany(mappedBy = "memberCard")
    private List<PurchaseCard> purchaseCardList;
    
    public MemberCardDto setDto() {
    	MemberCardDto dto = new MemberCardDto();
    	dto.setMcSeq(mcSeq);
    	dto.setMbSeq(member.getMbSeq());
    	dto.setMbId(member.getMbId());
    	dto.setMbNick(member.getMbNick());
    	dto.setCardSeq(card.getCardSeq());
    	dto.setCardNm(card.getCardNm());
    	return dto;
    }
}
