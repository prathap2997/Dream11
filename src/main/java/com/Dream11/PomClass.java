package com.Dream11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PomClass {

	     private AndroidDriver driver;
	     
	     
	     public PomClass(AndroidDriver driver) {
	         this.driver=driver;
	         PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	  	
	  	}
	     
	    
	     
	     public AndroidDriver getDriver() {
			return driver;
		}

	     @AndroidBy(xpath = "//android.widget.TextView[@text='Log In']")
		 private WebElement login;
	   
	     public WebElement getContinueButton() {
			return continueButton;
		}

		@AndroidBy(xpath = "//android.widget.Button[@text='CONTINUE']")
		 private WebElement continueButton;
		public WebElement getLogin() {
			return login;
		}



		public WebElement getEnterMobileNum() {
			return enterMobileNum;
		}



		public WebElement getNextButton() {
			return nextButton;
		}



		public WebElement getAllowButton() {
			return allowButton;
		}



		public WebElement getViewAllMatches() {
			return viewAllMatches;
		}



		public WebElement getCricketTag() {
			return cricketTag;
		}



		public WebElement getPractise() {
			return practise;
		}



		public WebElement getJoin() {
			return join;
		}



		public WebElement getCreateTeam() {
			return createTeam;
		}



		public WebElement getBat() {
			return bat;
		}



		public WebElement getAllRounder() {
			return allRounder;
		}



		public WebElement getBowler() {
			return bowler;
		}



		public WebElement getCreateTeamNextButton() {
			return createTeamNextButton;
		}



		public WebElement getCaptain() {
			return captain;
		}



		public WebElement getVicecaptain() {
			return vicecaptain;
		}



		public WebElement getCreateTeamSaveButton() {
			return createTeamSaveButton;
		}

		@AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='Login']/android.view.ViewGroup[5]/android.view.ViewGroup[1]")
	 	private WebElement enterMobileNum;
	     
	     @AndroidBy(xpath = "//android.widget.TextView[@text='Next']")
		 	private WebElement nextButton;
	     
	    
	      @AndroidBy(xpath = "//android.widget.Button[@text='Allow']")
		 	private WebElement allowButton;
	     
	     @AndroidBy(xpath = "//android.widget.TextView[@content-desc='view-all-matches']")
		 	private WebElement viewAllMatches;
	     
	     @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='tagCricket']/android.view.ViewGroup")
	     private WebElement cricketTag;
	     
	     public List<WebElement> listOfTimes(){
	    	 return driver.findElements(By.xpath("//android.widget.TextView[@content-desc='timer']"));
	     }
	  
	     public List<WebElement> listOfMatch(){
	    	 return driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'Match_Card')]"));
	     }
	     
	     @AndroidBy(xpath = "//android.widget.TextView[@content-desc='Practice Contests']")
	     private WebElement practise;
	     
	     @AndroidBy(xpath = "(//android.widget.TextView[@text='JOIN'])[1]")
	     private WebElement join;
	     
	     @AndroidBy(xpath = "(//android.widget.TextView[@text='CREATE TEAM'])[2]")
	     private WebElement createTeam;
	     
	     public List<WebElement> players(){
	    	 return driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'player-row')]"));
	     }
	     
	     @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='btnBAT']")
	     private WebElement bat;
	     
	     @AndroidBy(xpath = " //android.view.ViewGroup[@content-desc='btnAR']")
	     private WebElement allRounder;
	   
	     
	     @AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='btnBOWL']")
	     private WebElement bowler;
	     
	  
	     @AndroidBy(xpath = " //android.view.ViewGroup[@content-desc='create-team-NEXT-button']")
	     private WebElement createTeamNextButton;
	     
	     
	    		   @AndroidBy(xpath = "(//android.view.ViewGroup[@content-desc='special-player-selector-item'])[1]/android.view.ViewGroup[2]")
	    		     private WebElement captain;
	    		   
	    		  
	    				   @AndroidBy(xpath = " (//android.view.ViewGroup[@content-desc='special-player-selector-item'])[2]/android.view.ViewGroup[3]")
	  	    		     private WebElement vicecaptain; 
	    				
	    				   @AndroidBy(xpath = " //android.view.ViewGroup[@content-desc='create-team-SAVE-button']")
		  	    		     private WebElement createTeamSaveButton; 
	    				   
	    				   public void chooseMatch() {
	    					   List<WebElement> listOfTimes = listOfTimes();
	    						List<WebElement> listOfMatch = listOfMatch();
	    						
	    						for (int i = 0; i < listOfTimes.size(); i++) {
	    							String time = listOfTimes.get(i).getText();
	    							if (time.contains("s")) {
	    							String minutes=time.split("m")[0];
	    								int mins = Integer.parseInt(minutes);
	    								if (mins>20) {
	    									listOfMatch.get(i).click();
	    									break;
	    								}
	    							} 
	    							
	    							else {
	    								String hours=time.split("h")[0];
	    								int hrs = Integer.parseInt(hours);
	    								if (hrs>=1) {
	    									listOfMatch.get(i).click();
	    									break;
	    								}
	    							}
	    						}
						}
	    				   
	    				   
	     
}
