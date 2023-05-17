package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static Integer calculate(String inputString) {

        if (inputString == null || inputString.length() == 0) {
            throw new IllegalArgumentException("null을 입력하였습니다.");
        }

        String exp = "[\\d+\\-*/ ]+";
        if (!inputString.matches(exp)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

        String[] tokens = inputString.split(" ");

        String operator = "";
        int result = 0;

        for (String token : tokens) {
            // 연산자 처리
            if ("+".equals(token)
                    || "-".equals(token)
                    || "*".equals(token)
                    || "/".equals(token)) {
                operator = token;
                continue;
            }

            // 숫자 처리
            int num = Integer.parseInt(token);

            if ("".equals(operator)) {
                result = num;
            }
            if ("+".equals(operator)) {
                result += num;
            }
            if ("-".equals(operator)) {
                result -= num;
            }
            if ("*".equals(operator)) {
                result *= num;
            }
            if ("/".equals(operator)) {
                result /= num;
            }
        }

        return result;
    }
}
