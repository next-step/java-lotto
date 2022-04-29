package stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndCalculate(String input) {
        int answer = 0;
        if(isBlank(input)) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }

        String[] calculations = input.split(" ");

        for (int i = 0; i < calculations.length-2; i+=2) {
            // calculations[i+2] = String.valueOf(calculate(calculations[i+1], new Operand(calculations[i]), new Operand(calculations[i+2])));
            calculations[i+2] = Calculation.of(calculations[i+1], calculations[i], calculations[i+2]).calculate();
            answer = Integer.parseInt(calculations[i+2]);
        }
        return answer;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
