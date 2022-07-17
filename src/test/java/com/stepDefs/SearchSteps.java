package com.stepDefs;

import com.pageObjects.SearchPage;
import com.utilities.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SearchSteps extends BasePage {


    SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

    @Given("user navigates to {string}")
    public void userNavigatesTo(String webUrl) {
        searchPage.NavigateToWebsite(webUrl);
    }

    @And("the website is displayed")
    public void theWebsiteIsDisplayed() {
        assertThat(searchPage.assertStartLogo(), is(true));
    }

    @When("user searches for gyms close to their home town {string}")
    public void userSearchesForGymsCloseToTheirHomeTown(String city) {
        searchPage.enterFindGym(city);
    }

    @And("the user accepts cookies")
    public void theUserAcceptsCookies() {
        searchPage.acceptCookies();
    }

    @Then("user is displayed with a list of gyms containing {string}")
    public void userIsDisplayedWithAListOfGymsContaining(String gymCentre) throws InterruptedException {
//        Thread.sleep(4000);
        assertThat(searchPage.getGynName(gymCentre), is(true));
    }

    @And("user clicks {string}")
    public void userClicks(String selectedLocation) {
        searchPage.clickGynName(selectedLocation);
    }
}
