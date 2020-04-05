package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utils.driver.WebDriverUtils;

public class PageTitleQuestion implements Question<Boolean> {

    private String PageTitle;

    public PageTitleQuestion (String title) {
        this.PageTitle = title;
    }

    @Override
    public Boolean answeredBy ( Actor actor ) {

        if(WebDriverUtils.getPageTitle().getTitle().equals(PageTitle)) {

            return true;
        }
        else{
            return false;
        }
    }

    public static PageTitleQuestion IaEqualsToWord(String title) {

        return new PageTitleQuestion(title);
    }

}
