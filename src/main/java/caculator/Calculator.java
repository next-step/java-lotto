package caculator;

import java.util.List;

public class Calculator {
    private Operator operator;

    public Calculator(Operator operator) {
        this.operator = operator;
    }

    int calculate(List<String> textArray) {
        int result = Integer.parseInt(textArray.get(0));
        for (int i = 1; i < textArray.size(); i = i + 2) {
            if (textArray.get(i) == "+") {
                result = operator.plus(result, Integer.parseInt(textArray.get(i + 1)));
            }
        }
        return result;
    }
}
