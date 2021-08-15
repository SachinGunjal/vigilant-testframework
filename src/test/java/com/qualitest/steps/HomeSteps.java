package com.qualitest.steps;

import com.qualitest.pages.BasePage;
import io.cucumber.java.en.Given;

public class HomeSteps extends BasePage {

    @Given("^the customer has navigated to Test script demo page in chrome$")
    public void the_customer_has_navigated_to_script_demo_page() throws Exception {
        initiateDriver("Chrome");
    }

}
