package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Operator {

    private String operator;
    private final List<String> operatorList = Arrays.asList("+","-","*","/");
    private final String OPERATOR_CREATOR_EXCEPTION = "Operator에는 사칙연산 기호만 입력 가능합니다.";

    public Operator(String operator) {
        if(!operatorList.contains(operator)){
            throw new IllegalArgumentException(OPERATOR_CREATOR_EXCEPTION);
        }
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
