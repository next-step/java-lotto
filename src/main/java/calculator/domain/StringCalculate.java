package calculator.domain;


import calculator.model.NumberParsing;
import calculator.model.Numbers;
import calculator.model.OperatorParsing;
import calculator.model.Operators;

import java.util.List;

import static calculator.domain.Operator.*;

public class StringCalculate {

    private final Numbers numbers;
    private final Operators operators;

    public StringCalculate(String[] numbers, String[] operators) {
        this.numbers = new Numbers(NumberParsing.addNumber(numbers));
        this.operators = new Operators(OperatorParsing.addOperator(operators));
    }

    public int calculates() {
        int number= 0;
        int size = operators.size();
        for(int i=0; i< size; i++){
            number = calculate();
        }
        return number;
    }

    private int calculate() {
        int number=0;
        List<Integer> findNumbers = numbers.findNumbers();
        List<String> findOperator = operators.findOperator();
        number  = operator(findOperator.get(0)).apply(findNumbers.get(0), findNumbers.get(1));
        numbers.addNumber(number);
        return number;
    }


}
