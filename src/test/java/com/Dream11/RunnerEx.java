package com.Dream11;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class RunnerEx extends BaseClass {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver driver=appLaunch();
		
		PomClass a= new PomClass(driver);
		
		clickElement(a.getContinueButton());
		   clickElement(a.getLogin());
		   clickAndSendKeys(a.getEnterMobileNum(),"9789090519");
		   clickElement(a.getNextButton());
		   clickElement(a.getAllowButton());
		   
		   if (a.getViewAllMatches()!=null) {
			   System.out.println("Logged in Successfully");
			   clickElement(a.getViewAllMatches());
		    }
		   else {
			   System.out.println("Logged in Successfully");
			   System.out.println("Already in view matches screen");
		}
		   
		   clickElement(a.getCricketTag());
		   
		
		a.chooseMatch();
		
		swipeDown(a.getPractise());
		swipeDown(a.getJoin());
		clickElement(a.getJoin());
		clickElement(a.getCreateTeam());
		
		Assert.assertTrue(a.getCreateTeamNextButton()!=null);
		System.out.println("Navigated to player selection Screen");
		
		//WicketKeeperSelection
		List<WebElement> wicketKeeper = a.players();
		clickElement(wicketKeeper.get(0));
		
		//batterSelection
		clickElement(a.getBat());
		List<WebElement> batter = a.players();
		for (int i = 0; i < batter.size(); i++) {
			if (i<6) {
				clickElement(batter.get(i));
			}
		}
		
		//AllRounderSelection
		clickElement(a.getAllRounder());
		List<WebElement> allRounder = a.players();
		for (int i = 0; i < allRounder.size(); i++) {
			if (i<3) {
				clickElement(allRounder.get(i));
			}
		}
		
		//BowlerSelection
		clickElement(a.getBowler());
		List<WebElement> bowlers = a.players();
		clickElement(bowlers.get(0));
		
		clickElement(a.getCreateTeamNextButton());
		
		Assert.assertTrue(a.getCreateTeamSaveButton()!=null);
		System.out.println("Navigated to captain and Vice-Captain selection Screen");
		
		clickElement(a.getCaptain());
		clickElement(a.getVicecaptain());
		
		clickElement(a.getCreateTeamSaveButton());
		
	
		
	}
	
}
