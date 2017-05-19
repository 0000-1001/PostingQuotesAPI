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
    @Produces(MediaType.APPLICATION_XML)
	public List<Quote> postToFacebook() throws IOException{
		
		
		String message = "Sample";
        QuoteResource quoteResource=new QuoteResource();
        message=quoteResource.getQuote()+"\n  -Dr. A.P.J. Abdul Kalam";
		
		
		BufferedImage bufferedImage = new BufferedImage(700, 400,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, 700, 400);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial Black", Font.BOLD, 10));
        
        graphics.drawString(message, 10, 180);
        ImageIO.write(bufferedImage, "jpg", new File("image.jpg"));
        FileInputStream fis=new FileInputStream(new File("image.jpg"));
        String accessToken="EAACEdEose0cBADOD91jDSjWVlYhclBnug1qOW0qlZB6PZCaOGikiEGgwhZBNLHb52zo0abSxv5LRACLZCl6tkW8RHUaZBr7FfKB6Uuq7Hf00XWZA0mppGvmOiADNe4IVrcmicAcDqCL0BnUSh8hF7I5enslvMPwuuilcfqVGbCHxvNrGTSLYU0vdLrvO9eGzYZD";
        FacebookClient facebookClient=new DefaultFacebookClient(accessToken);
        FacebookType facebookType=facebookClient.publish("me/photos", FacebookType.class, BinaryAttachment.with("image.jpg", fis), Parameter.with("Message", "This is for Test"));
		User user=facebookClient.fetchObject("me", User.class);
		QuoteService quoteService=new QuoteService();
		Quote quote = quoteService.getQuote(facebookType, user,message);
		List<Quote> quotes=new ArrayList<>();
		quotes.add(quote);
		//quotes.add(new Quote("","","","",new Date()));
    	return quotes;
	}
}
