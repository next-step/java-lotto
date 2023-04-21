package Calculator;

import Calculator.View.*;
import Calculator.Model.*;
import Util.*;

import java.util.ArrayList;


public class CalculatorController {
    private static final Integer INDEX_CALCULATE_CURRENT_ELEMENT = 0;
    private static final String INITIAL_NUMBER_BEFORE_ARGUMENT = "0";
    private static final String INITIAL_OPERATOR = "+";


    public void start() {


        System.out.println("계산기를 시작합니다.");

        String[] elements = InputView.getAlgebra();

        ArrayList<String> results = new ArrayList<>();
        results.add(INITIAL_NUMBER_BEFORE_ARGUMENT);
        results.add(INITIAL_OPERATOR);

        Calculator calculator = new Calculator();
        for (String element : elements) {
            results.add(element);
            results = calculator.calculate(results);
        }

        System.out.println("계산 결과는 " + results.get(INDEX_CALCULATE_CURRENT_ELEMENT) + "입니다.");
    }

}
