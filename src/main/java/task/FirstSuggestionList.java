package task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import user_interfaces.MyElement;

import java.util.List;

public class FirstSuggestionList implements Task {

    @Override
    public <T extends Actor> void performAs ( T actor ) {
        List<WebElementFacade> list = MyElement.SUGGESTIONS_LIST.resolveAllFor(actor);
        actor.attemptsTo(Click.on(list.get(0)));
    }
    public static FirstSuggestionList Open() {
        return Tasks.instrumented(FirstSuggestionList.class);
    }
}
