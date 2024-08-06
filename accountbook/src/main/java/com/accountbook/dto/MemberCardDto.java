package com.accountbook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCardDto {
	private Integer mcSeq;
	
    private Integer mbSeq;

    private String mbId;

    private String mbNick;
    
    private Integer cardSeq;

    private String cardNm;
}
