package com.books.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import lombok.Data;

@Entity
public class Books {
	
	@Id
	@JsonProperty("book_id")
	private Integer BookID;
	
	@JsonProperty("author")
	private String Author;
	
	@JsonProperty("book_name")
	private String BooKName;
	
	public Books (){
		
	}
	
	public Books (Integer BookId,String Author,String BookName) {
		this.BookID=BookId;
		this.Author=Author;
		this.BooKName=BookName;
	}
	
}