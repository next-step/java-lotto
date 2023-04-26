package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    private final List<String> formulaList;
    private Double result;

    public Calculator(List<String> formulaList) {
        this.formulaList = new ArrayList<>(formulaList);
        this.result = 0.0;
    }

    public void calculateFormula() {
        List<Double> numberList = makeNumberList();
        List<String> operatorList = makeOperatorList();
        Queue<String> operatorQueue = new LinkedList<>(operatorList);

        this.result = numberList.stream()
                .reduce((x, y) -> calculate(x, y, operatorQueue.remove()))
                .get();


    }

    public List<Double> makeNumberList() {
        return IntStream.range(0, this.formulaList.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> Double.parseDouble(this.formulaList.get(index)))
                .collect(Collectors.toList());
    }

    public List<String> makeOperatorList() {
        return IntStream.range(0, this.formulaList.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(this.formulaList::get)
                .collect(Collectors.toList());
    }

    public Double calculate(Double number1, Double number2, String operator) {
        System.out.println("--------------------------");
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(operator);

        if(operator == "+") {
            System.out.println(number1 + number2);
            return number1 + number2;
        }

        if(operator == "-") {
            System.out.println(number1 - number2);
            return number1 - number2;
        }

        if(operator == "*") {
            System.out.println(number1 * number2);
            return number1 * number2;
        }
        System.out.println(number1 / number2);
        return number1 / number2;


    }

    public Double showResult() {
        return result;
    }
}
