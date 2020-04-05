package task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import user_interfaces.MyElement;

import java.util.List;

public class FirstSuggestionList implements Task {
    private String positionNumber;
    int lenght;

    public FirstSuggestionList ( String number) {
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

        List<WebElementFacade> list = MyElement.SUGGESTIONS_LIST.resolveAllFor(actor);
        actor.attemptsTo(Click.on(list.get(lenght)));
    }


    public static FirstSuggestionList Open(String number){

        return new FirstSuggestionList(number);
    }
}
