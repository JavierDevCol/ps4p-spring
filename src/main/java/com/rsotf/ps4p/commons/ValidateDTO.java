package com.rsotf.ps4p.commons;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ValidateDTO<E> {

	private boolean status;
	private String menssage;
	private E data;
}
