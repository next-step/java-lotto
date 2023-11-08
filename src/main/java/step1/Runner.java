package step1;

import step1.domain.Operator;
import step1.domain.Seperator;
import step1.view.InputView;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Seperator seperator = new Seperator(InputView.inputText());

        List<Integer> numbers = seperator.numbers();
        List<Operator> operators = seperator.operators();

    }

}
