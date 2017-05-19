package org.jugnoo.assignment.PostingQuotesAPI.service;

import java.util.Date;

import org.jugnoo.assignment.PostingQuotesAPI.model.Quote;
import org.jugnoo.assignment.PostingQuotesAPI.resources.QuoteResource;

import com.restfb.types.FacebookType;
import com.restfb.types.User;

public class QuoteService {
	public Quote getQuote(FacebookType facebookType,User user,String message){
		QuoteResource quoteResource=new QuoteResource();
		Quote q=new Quote("fb.com/"+facebookType.getId().toString(),message,user.getName(),"fb.com/"+user.getId(),new Date());
		return q;
	}
}
