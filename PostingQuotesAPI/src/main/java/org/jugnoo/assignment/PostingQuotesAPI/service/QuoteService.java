/*
this class initializes the Quote when PostToFacebook calls after the response from facebook
*/

package org.jugnoo.assignment.PostingQuotesAPI.service;

import java.util.Date;

import org.jugnoo.assignment.PostingQuotesAPI.model.Quote;
import org.jugnoo.assignment.PostingQuotesAPI.resources.QuoteResource;

import com.restfb.types.FacebookType;
import com.restfb.types.User;

public class QuoteService {
	public Quote getQuote(FacebookType facebookType,User user,String message){
		QuoteResource quoteResource=new QuoteResource();
		
		//initilizing the quote after getting respose from facebook
		Quote q=new Quote("fb.com/"+facebookType.getId().toString(),message,user.getName(),"fb.com/"+user.getId(),new Date());
		return q;
	}
}
