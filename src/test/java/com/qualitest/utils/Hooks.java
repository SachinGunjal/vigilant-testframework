package com.qualitest.utils;

import com.qualitest.pages.BasePage;
import io.cucumber.java.After;

public class Hooks extends BasePage {

    @After
    public void afterTest() {
        driver.quit();
    }
}
