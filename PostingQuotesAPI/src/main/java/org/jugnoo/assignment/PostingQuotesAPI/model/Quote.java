/*
This class is for initiliazation of Quotes
*/


package org.jugnoo.assignment.PostingQuotesAPI.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Quote {
	private String quoteId;//post id returned from facebook
	private String quote;//Actual quote of the timeline
	private String author;//Author of the Quote
	private String userId;//facebook Id of the user to whom the image is posted
	private Date created;//created date of th epost
	private String userName;//Name of the user to whom post is posted
	
	public Quote(String quoteId,String quote,String userName,String userId,Date created){//Initilizes the Quote
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
