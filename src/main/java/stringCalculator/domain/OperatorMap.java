package stringCalculator.domain;

import stringCalculator.common.OperatorEnum;
import stringCalculator.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {

    private Map<String, CalculatorStrategy> strategyMap;

    public OperatorMap() {
        create();
    }

    private void create() {
        this.strategyMap = new HashMap<>();

        strategyMap.put(OperatorEnum.PLUS.getCode(), new PlusStrategy());
        strategyMap.put(OperatorEnum.MINUS.getCode(), new MinusStrategy());
        strategyMap.put(OperatorEnum.MULTIPLY.getCode(), new MultiplyStrategy());
        strategyMap.put(OperatorEnum.DIVIDE.getCode(), new DivideStrategy());
    }

    public CalculatorStrategy getStrategy(String operator) {
        isOperator(operator);

        return this.strategyMap.get(operator);
    }

    private void isOperator(String operator) {

        if(strategyMap.get(operator) == null) {
            throw new IllegalArgumentException("사칙 연산 문자열이 올바르지 않습니다.");
        }
    }

}
