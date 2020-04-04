package task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import user_interfaces.MyElement;

import java.util.List;

public class OpenFirstResult implements Task {

    @Override
    public <T extends Actor> void performAs ( T actor ) {
        List<WebElementFacade> results = MyElement.RESULTS_SHOW.resolveAllFor(actor);
        actor.attemptsTo(
                Click.on(results.get(0))
        );
    }
    public static OpenFirstResult GivingClickHere() {
        return Tasks.instrumented(OpenFirstResult.class);
    }
}
