package step_definitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exception.ShowTheResultsSearchException;
import exception.ShowTheResultsWordException;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.PageTitleQuestion;
import questions.ShowTheResultsSearchQuestion;
import questions.ShowTheResultsWordQuestion;
import task.*;
import utils.driver.WebDriverUtils;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class GoogleSearchStepDefinitions {

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        theActorCalled("Search User");
    }

    @Given("^I am on the homepage$")
    public void i_am_on_the_homepage() {
        theActorInTheSpotlight()
        .can(BrowseTheWeb.with(WebDriverUtils.inThePage("https://www.google.com/")));
    }


    @When("^I type (.*) into the search field$")
    public void i_type_The_name_of_the_wind_into_the_search_field(String word) {
        theActorInTheSpotlight().attemptsTo(TypeIntoTheSearchField.WithThisInformation(word));

    }

    @When("^I click the Google Search button$")
    public void i_click_the_Google_Search_button() {
         theActorInTheSpotlight().attemptsTo(SearchInformationOnGoogle.WhitThisButton());
    }

    @Then("^I go to the search results page$")
    public void i_go_to_the_search_results_page() {
         theActorInTheSpotlight().should(GivenWhenThen.seeThat(
         ShowTheResultsSearchQuestion.text()).orComplainWith(
         ShowTheResultsSearchException.class,ShowTheResultsSearchException.MESSAGE_RESULT_SEARCH)
         );
    }

    @Then("^the (.*) result is (.*)$")
    public void the_first_result_is_The_Name_of_the_Wind_Patrick_Rothfuss(String number, String find) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
        ShowTheResultsWordQuestion.ReturnWord(number,find)).orComplainWith(
        ShowTheResultsWordException.class,ShowTheResultsWordException.MESSAGE_WORD_SEARCH));
    }

    @When("^I click on the (.*) result link$")
    public void i_click_on_the_first_result_link(String number) {
         theActorInTheSpotlight().attemptsTo(OpenFirstResult.GivingClickHere(number));
    }

    @Then("^I am in the (.*) page$")
    public void i_go_to_the_Patrick_Rothfuss_The_Books_page(String title) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
        PageTitleQuestion.IaEqualsToWord(title)));
    }


    @When("^the suggestions list is displayed$")
    public void theSuggestionsListIsDisplayed() {
         theActorInTheSpotlight().attemptsTo(SuggestionList.IsDisplayed());
    }

    @When("^I click on the (.*) suggestion in the list$")
    public void iClickOnTheFirstSuggestionInTheList(String number) {
         theActorInTheSpotlight().attemptsTo(FirstSuggestionList.Open(number));
    }


}
