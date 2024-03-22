package calculator.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern OPERATOR = Pattern.compile("[+\\-*/]");

    public static void checkCount(List<String> operands, List<String> operators) {

        if (operands.size() <= operators.size() ) {
            throw new IllegalArgumentException("연산할 숫자가 부족합니다.");
        }

    }

    public static String operatorCheck(String splitExpression) {
        Matcher matcher = OPERATOR.matcher(splitExpression);

        if (!matcher.find()) {
            throw new RuntimeException("올바른 연산자를 입력해주세요.");
        }

        return splitExpression;

    }

    public static int division(int result, int targetNum) {
        if(targetNum == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        if(result % targetNum != 0) {
            throw new IllegalArgumentException("연산 결과가 정수가 아닙니다.");
        }

        return result / targetNum;

    }

}
