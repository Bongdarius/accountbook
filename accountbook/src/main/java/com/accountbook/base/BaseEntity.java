package com.accountbook.base;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	
	@Column(nullable = true)
	private Integer regUserId;
	
	@Column(nullable = true)
	private LocalDateTime regDt;
	
	@Column(nullable = true)
	private Integer modUserId;
	
	@Column(nullable = true)
	private LocalDateTime modDt;	
}
