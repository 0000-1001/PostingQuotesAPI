/*

this class is for posting the image to the user's timeline

*/


package org.jugnoo.assignment.PostingQuotesAPI.postToFacebook;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jugnoo.assignment.PostingQuotesAPI.model.Quote;
import org.jugnoo.assignment.PostingQuotesAPI.resources.QuoteResource;
import org.jugnoo.assignment.PostingQuotesAPI.service.QuoteService;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
@Path("post")
public class PostToFacebook {

	@GET
    @Produces(MediaType.APPLICATION_XML)//this produces response as xml 
	public List<Quote> postToFacebook() throws IOException{
	String message = "Sample";//This contains the actual quote String
        QuoteResource quoteResource=new QuoteResource();//calling for the new quote
        message=quoteResource.getQuote()+"\n  -Dr. A.P.J. Abdul Kalam";
		
	//drawing the image	
	BufferedImage bufferedImage = new BufferedImage(700, 400,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, 700, 400);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial Black", Font.BOLD, 10));
        
	//writing the Quote on the image
        graphics.drawString(message, 10, 180);
	
	//savig the image in file system so that we can fetch this whle posting it to facebook
        ImageIO.write(bufferedImage, "jpg", new File("image.jpg"));
        
	//taking the saved image as input
	FileInputStream fis=new FileInputStream(new File("image.jpg"));
	
	//taking the access token to access the user's profile for posting the image
        String accessToken="EAACEdEose0cBADOD91jDSjWVlYhclBnug1qOW0qlZB6PZCaOGikiEGgwhZBNLHb52zo0abSxv5LRACLZCl6tkW8RHUaZBr7FfKB6Uuq7Hf00XWZA0mppGvmOiADNe4IVrcmicAcDqCL0BnUSh8hF7I5enslvMPwuuilcfqVGbCHxvNrGTSLYU0vdLrvO9eGzYZD";
        FacebookClient facebookClient=new DefaultFacebookClient(accessToken);
	
	//Posting the image to user's tmeline
        FacebookType facebookType=facebookClient.publish("me/photos", FacebookType.class, BinaryAttachment.with("image.jpg", fis), Parameter.with("Message", "This is for Test"));
	
	//getting the user's information to whom the image is posted
	User user=facebookClient.fetchObject("me", User.class);
	
	
	QuoteService quoteService=new QuoteService();
	Quote quote = quoteService.getQuote(facebookType, user,message);
	List<Quote> quotes=new ArrayList<>();
	quotes.add(quote);
	
	//returning the list of quotes in xml formate.
	//actually it is always one because there is only one post i am posting at atime
    	return quotes;
	}
}
