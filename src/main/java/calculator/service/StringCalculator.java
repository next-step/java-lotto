package calculator.service;

import calculator.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCalculator {

    private final Map<String, Operator> operatorMap;

    public StringCalculator() {
        operatorMap = new HashMap<>();
        operatorMap.put("+", new Plus());
        operatorMap.put("-", new Minus());
        operatorMap.put("*", new Multiply());
        operatorMap.put("/", new Divide());
    }

    public int calculator(List<String> numbersAndSings) {
        int result = convertoInt(numbersAndSings.get(0));
        for (int i = 1; i < numbersAndSings.size(); i += 2) {
            result = operate(result, convertoInt(numbersAndSings.get(i + 1)), numbersAndSings.get(i));
        }
        return result;
    }

    public int operate(int firstNum, int secondNum, String operator) {
        Operator operatorMapping = operatorMap.get(operator);
        if (operatorMapping == null) {
            throw new IllegalArgumentException("올바르지 않은 연산자 입니다 : " + operator);
        }
        return operatorMapping.calculate(firstNum, secondNum);
    }

    private int convertoInt(String str) {
        if(!str.matches("\\d+")){
            throw new IllegalArgumentException("올바르지 않은 숫자 입니다. : " + str);
        }
        return Integer.parseInt(str);
    }
}
