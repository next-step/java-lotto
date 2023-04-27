package lotto.domain;

import java.text.NumberFormat;
import java.util.List;
import java.util.Queue;

public class Calculator {
    private static NumberFormat numberFormat = NumberFormat.getInstance();
    private String result;

    public Calculator() {
        this.result = "0";
    }

    private String calculate(String number1, String number2, String operator) {
        Double doubleNumber1 = Double.parseDouble(number1);
        Double doubleNumber2 = Double.parseDouble(number2);
        numberFormat.setGroupingUsed(false);

        if(operator.equals("+")) {
            return numberFormat.format(doubleNumber1 + doubleNumber2);
        }

        if(operator.equals("-")) {
            return numberFormat.format(doubleNumber1 - doubleNumber2);
        }

        if(operator.equals("*")) {
            return numberFormat.format(doubleNumber1 * doubleNumber2);
        }

        return numberFormat.format(doubleNumber1 / doubleNumber2);
    }

    public void calculateFormula(List<String> numberList, Queue<String> operatorQueue) {
        this.result = numberList.stream()
                .reduce((x, y) -> this.calculate(x, y, operatorQueue.remove()))
                .get();
    }

    public String showResult() {
        return result;
    }
}
