package com.booksystem.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Book implements Serializable{
	private Integer id;
	private String name;
	private Integer price;
	private String publish;
	private Date dob;
	private Integer num;//剩余数量
	private String author;
	private String img;//封面
}
