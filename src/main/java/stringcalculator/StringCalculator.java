package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static Integer calculate(String s) {

        String[] tokens = s.split(" ");

        String operator = "";
        int result = 0;

        for(String token : tokens) {
            // 연산자 처리
            if("+".equals(token) || "-".equals(token)) {
                operator = token;
                continue;
            }

            // 숫자 처리
            int num = Integer.parseInt(token);

            if("".equals(operator)) {
                result = num;
            }
            if("+".equals(operator)) {
                result += Integer.parseInt(token);
            }
            if("-".equals(operator)) {
                result -= Integer.parseInt(token);
            }
        }

        return result;
    }
}
