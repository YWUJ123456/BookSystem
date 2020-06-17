package com.booksystem.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable{
	private Integer id;
	private String name;
	private String password;
	private Integer role;//角色 1:管理员   0: 普通用户
}
