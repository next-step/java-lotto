package caculator;

import java.util.List;

public class Calculator {
    private Operator operator;

    private final Number resultNumber;

    public Number getResultNumber(){
        return resultNumber;
    }

    public Calculator(Operator operator) {
        this.operator = operator;
        resultNumber = new Number(0);
    }

    void calculate(List<String> textArray) {
        resultNumber.plus(new Number(textArray.get(0)));
        for (int i = 1; i < textArray.size(); i = i + 2) {
            getNumber(textArray.get(i), textArray.get(i + 1));
        }
    }

    private void getNumber(String operatorValue, String numberValue) {
        if (operatorValue.equals("+")) {
            resultNumber.plus(new Number(numberValue));
        }
    }
}
