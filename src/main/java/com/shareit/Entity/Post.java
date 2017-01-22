package com.shareit.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shareit.Entity.User;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	public Post(Long id){
		this.id = id;
	}
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "body")
	private String body;
	
	@ManyToOne
	@JoinColumn(name = "author")
	private User author;
	
	@Column(name = "pubDate")
	private Date pubDate = new Date();
	
	@Column(name = "updateDate")
	private Date updateDate;
	
	public Post(String title, String body, User author, Date pub_date, Date update_date){
		this.title = title;
		this.body = body;
		this.author = author;
		this.pubDate = pubDate;
		this.updateDate = updateDate;
	}
	
	public Post(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
