package com.booksystem.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Bp implements Serializable{
	private Integer book_id;
	private Integer person_id;
	private Integer state;
}
