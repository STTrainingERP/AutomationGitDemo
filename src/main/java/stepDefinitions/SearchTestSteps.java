package stepDefinitions;

import commonLibraries.CommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SearchTestSteps extends CommonFunctions {


    @Given("I'm on home page {string}")
    public void openHomePage(String url){

        driver.get(url);
//        driver.manage().deleteAllCookies();


    }

    @When("I Click on search field and enter the search term {string}")
    public void enterSearchTerm(String searchTerm){

        wait(driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")));
        driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button")).click();

        wait(driver.findElement(By.xpath("//*[@id=\"header-big-screen-search-box\"]")));
        driver.findElement(By.id("header-big-screen-search-box")).sendKeys(searchTerm);

    }

    @And("I click on search icon")
    public void clickSearchIcon(){

        driver.findElement(By.xpath("//*[@id=\"header-search-form\"]/button")).click();

    }

    @Then("I should see products related to {string} in search results page")
    public void verifyAllSearchResults(String expectedText) throws IOException {

            List<WebElement> allProducts = driver.findElements(By.xpath("//*[@class=\"TitleText\"]/span"));

            for (WebElement products:allProducts) {

                if(products.getText().contains(expectedText)){

                    System.out.println(products.getText()+" contains "+expectedText);

                }else{

                    System.out.println(products.getText()+" does not contain "+expectedText);
                    takeScreenshots(products.getText());

                }

            }





    }

}
