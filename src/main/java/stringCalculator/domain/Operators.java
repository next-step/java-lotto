package stringCalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {
    private static List<String> operators = new ArrayList<>();

    private final String REGEX = "[-*/+]+";

    public Operators() {};

    public Operators(String operator) {
        operators.add(validOperator(operator));
    }

    public String validOperator(String operator) {
        if(!REGEX.contains(operator)) {
            throw new IllegalArgumentException("사칙연산 기호를 입력해주세요");
        }
        return operator;
    }

    public List<String> getOperators() {
        return operators;
    }


}
