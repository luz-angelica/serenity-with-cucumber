package task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import user_interfaces.MyElement;

import java.util.List;

public class OpenFirstResult implements Task {

    private String positionNumber;
    int lenght;

    public OpenFirstResult ( String number) {
        this.positionNumber = number;
    }

    @Override
    public <T extends Actor> void performAs ( T actor ) {

        switch (positionNumber.toLowerCase()){
            case "first":
                lenght=0;
                break;
            case "second":
                lenght=1;
                break;
            case "third":
                lenght=2;
                break;
            case "fourth":
                lenght=3;
                break;
            case "fifth":
                lenght=4;
                break;
        }

        List<WebElementFacade> results = MyElement.RESULTS_SHOW.resolveAllFor(actor);

        actor.attemptsTo(
                Click.on(results.get(lenght))
        );
    }
    public static OpenFirstResult GivingClickHere(String number) {

        return new OpenFirstResult(number);
    }
}
