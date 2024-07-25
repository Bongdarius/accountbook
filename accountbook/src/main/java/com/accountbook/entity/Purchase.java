package com.accountbook.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.accountbook.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "purchase")
public class Purchase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_seq_generator")
    @SequenceGenerator(name = "purchase_seq_generator", sequenceName = "purchase_seq", allocationSize = 1)
    @ColumnDefault("nextval('purchase_seq'::regclass)")
    private Integer pcSeq; // 결제 일련번호
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "mb_seq", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "pcm_seq", nullable = false)
    private PurchaseMethod purchaseMethod; // 결제 수단 일련번호

    @OneToOne
    @JoinColumn(name = "pc_seq", nullable = false)
    private PurchaseCard purchaseCard;
    
    @Column(name = "pc_amt", nullable = false)
    private BigDecimal pcAmt; // 결제 금액

    @Column(name = "pc_datetime", nullable = false)
    private LocalDateTime pcDatetime; // 결제 일시
    
    
    
}
