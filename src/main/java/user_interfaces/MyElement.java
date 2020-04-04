package user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class MyElement {

    public static final Target LABEL_SEARCH_WORD =
    Target.the("Label where write search word").located(By.name("q"));
    public static final Target GOOGLE_SEARCH_BUTTON =
    Target.the("google search button").located(By.xpath("//*[@id='tsf']//center/input[1]"));
    public static final Target TEXT_RESULT_SEARCH =
    Target.the("Text where show results number").located(By.xpath("//*[@id='result-stats']"));
    public static final Target RESULTS_SHOW =
    Target.the("All search results").located(By.xpath("//*[@class='LC20lb DKV0Md']"));
    public static final Target FIRST_RESULT =
    Target.the("The first search result").located(By.xpath("'//*[@id='rso']//*/h3"));
    public static final Target SUGGESTIONS_LIST =
    Target.the("Show the suggestion list when write search word").located(By.className("sbct"));
}
