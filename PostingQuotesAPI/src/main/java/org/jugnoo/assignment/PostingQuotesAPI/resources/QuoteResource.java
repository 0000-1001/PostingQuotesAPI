/*
This class works as Quote Resource where quotes are created and returned when needed
*/


package org.jugnoo.assignment.PostingQuotesAPI.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("quotes")
public class QuoteResource {
	public List<String> quotes;//List of quotes
	public QuoteResource(){//constructor for QuoteResource
		quotes=new ArrayList<>();//creating new Arraylist that contains the list of quotes available
		
		//adding the quotes to the list
		quotes.add("Failure will never overtake me if my determination to succeed is strong enough.");
		quotes.add("Don’t take rest after your first victory because if you fail in second, more lips are waiting to say that your first victory was just luck.");
		quotes.add("All Birds find shelter during a rain. But Eagle avoids rain by flying above the Clouds.");
		quotes.add("Man needs difficulties in life because they are necessary to enjoy the success.");
		quotes.add("If you want to shine like a sun. First burn like a sun.");
		quotes.add("All of us do not have equal talent. But , all of us have an equal opportunity to develop our talents.");
		quotes.add("Be more dedicated to making solid achievements than in running after swift but synthetic happiness.");
		quotes.add("Thinking should become your capital asset, no matter whatever ups and downs you come across in your life.");
		quotes.add("Without your involvement you can't succeed. With your involvement you can't fail.");
	}
	
	//this function is user for returning a single quote when needed
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getQuote(){
		Random random = new Random();
		String message=quotes.get(Math.abs(random.nextInt()) % 9);
		int len=message.length();
		String message1="";
		for(int i=0;i<len/2;i++){
			message1=message1+message.charAt(i);
		}
		message1=message1+'\n';
		for(int i=len/2;i<len;i++){
			message1=message1+message.charAt(i);
		}
		return message1;
		
	}
	
}
