package Calculator;

import Calculator.View.*;
import Calculator.Model.*;
import Util.*;

import java.util.ArrayList;


public class CalculatorController {
    private static final Integer INDEX_CALCULATE_CURRENT_ELEMENT = 0;

    public void start() {
        System.out.println("계산기를 시작합니다.");

        String[] elements = InputView.getAlgebra();

        String numberBeforeArgument = "0";
        String operator = "+";
        ArrayList<String> results = new ArrayList<>();
        results.add(numberBeforeArgument);
        results.add(operator);

        Calculator calculator = new Calculator();
        for (String element: elements) {
            results.add(element);
            results = calculator.calculate(results);
        }

        System.out.println("계산 결과는 " + results.get(INDEX_CALCULATE_CURRENT_ELEMENT) + "입니다.");
    }

}
