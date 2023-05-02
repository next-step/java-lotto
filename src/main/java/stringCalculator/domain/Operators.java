package stringCalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Operators {

    private List<String> operators = new ArrayList<>();

    public Operators() {};

    public void addOperators(String operator) {
        validOperator(operator);
        operators.add(operator);
    }

    //사칙연산 정규표현식 확인
    public void validOperator(String operator) {
        if(!Pattern.matches("^[-*/+]*$", operator)) {
            throw new IllegalArgumentException("사칙연산 기호를 입력해주세요");
        }
    }

    public List<String> getOperators() {
        return operators;
    }


}
