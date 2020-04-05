package questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import user_interfaces.MyElement;

import java.util.List;
import java.util.stream.Collectors;

public class ShowTheResultsWordQuestion  implements Question<Boolean> {
    private String wordFind;
    private String positionNumber;
    int lenght;

    public ShowTheResultsWordQuestion ( String number,String find ) {
        this.positionNumber = number;
        this.wordFind = find;
    }

    @Override
    public Boolean answeredBy ( Actor actor ) {
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

        List<WebElementFacade> list = MyElement.RESULTS_SHOW.resolveAllFor(actor);
        List<String> getText = list.stream().map(element -> element.getText()).collect(Collectors.toList());

        if (getText.get(lenght).contains(wordFind)){

               return true;

            }
        else{

                return false;

            }
    }

    public static ShowTheResultsWordQuestion ReturnWord(String number,String find) {

        return new ShowTheResultsWordQuestion(number,find);
    }

}
