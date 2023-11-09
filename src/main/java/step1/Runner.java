package step1;

import step1.domain.Calculator;
import step1.domain.Operator;
import step1.domain.Seperator;
import step1.view.InputView;

import java.util.LinkedList;

public class Runner {

    public static void main(String[] args) {
        Seperator seperator = new Seperator(InputView.inputText());

        LinkedList<Integer> numbers = seperator.numbers();
        LinkedList<Operator> operators = seperator.operators();

        int result = Calculator.calculation(numbers, operators);
    }

}
