package step1.domain.calculator;

import step1.domain.operator.AddOperator;
import step1.domain.operator.DivideOperator;
import step1.domain.operator.MultiplyOperator;
import step1.domain.operator.Operator;
import step1.domain.operator.SubtractOperator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Operator operator;

    private Map<String, Operator> operatorMap;

    public Calculator() {
        operatorMap = new HashMap<>();
        operatorMap.put("+", new AddOperator());
        operatorMap.put("-", new SubtractOperator());
        operatorMap.put("*", new MultiplyOperator());
        operatorMap.put("/", new DivideOperator());
    }

    public Operator operator() {
        return operator;
    }

    public void updateOperator(String operatorStr) {
        if (!operatorMap.containsKey(operatorStr)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        this.operator = operatorMap.get(operatorStr);
    }

    public int calculate(int result, int secondNumber) {
        return this.operator.operate(result, secondNumber);
    }
}
