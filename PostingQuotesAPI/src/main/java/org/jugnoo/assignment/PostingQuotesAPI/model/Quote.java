package org.jugnoo.assignment.PostingQuotesAPI.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Quote {
	private String quoteId;
	private String quote;
	private String author;
	private String userId;
	private Date created;
	private String userName;
	
	public Quote(String quoteId,String quote,String userName,String userId,Date created){
		this.quoteId=quoteId;
		this.quote=quote;
		this.created=created;
		this.author="A.P.J. Abdul Kalam";
		this.userName=userName;
		this.userId=userId;
	}
	public Quote(){
		
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return this.userName;
	}
	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	public String getQuoteId(){
		return this.quoteId;
	}
	public void setQuoteId(String id){
		this.quoteId=id;
	}
	public String getQuote(){
		return this.quote;
	}
	public void setQuote(String quote){
		this.quote=quote;
	}
	public Date getCreated(){
		return this.created;
	}
	public void setCreated(Date date){
		this.created=new Date();
	}
	public String getAuthor(){
		return "Dr. A.P.J. Abdul Kalam";
	}
	public void setAuthor(String str){
		this.author="Dr. A.P.J. Abdul Kalam";
	}
}
