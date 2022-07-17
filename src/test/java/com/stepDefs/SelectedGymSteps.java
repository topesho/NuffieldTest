package com.stepDefs;

import com.pageObjects.SelectedGymPage;
import com.utilities.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SelectedGymSteps extends BasePage {

    SelectedGymPage selectedGymPage = PageFactory.initElements(driver, SelectedGymPage.class);

    @And("the gym contact name is {string}")
    public void theGymContactNameIs(String selectedLocation) {
        assertThat(selectedGymPage.getGymFullName(), equalTo(selectedLocation));
    }
}
