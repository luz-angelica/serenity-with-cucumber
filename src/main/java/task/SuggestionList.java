package task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import user_interfaces.MyElement;

import java.util.List;
import java.util.stream.Collectors;

public class SuggestionList implements Task {

    @Override
    public <T extends Actor> void performAs ( T actor ) {
        List<WebElementFacade> list = MyElement.SUGGESTIONS_LIST.resolveAllFor(actor);
        List<String> getText = list.stream().map(element -> element.getText()).collect(Collectors.toList());
        System.out.print(getText);
    }
    public static SuggestionList IsDisplayed() {
        return Tasks.instrumented(SuggestionList.class);
    }

}
