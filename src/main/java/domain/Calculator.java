package domain;

import java.util.Arrays;

public class Calculator {
    public static int calculate(String input) {
        int currentNumber = 0;
        boolean isFirst = true;

        String[] tokens = input.split(" ");
        String operator = "";

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-")) {
                operator = token;
                continue;
            }

            if (isFirst) {
                currentNumber = Integer.parseInt(token);
                isFirst = false;
                continue;
            }

            try {
                if (operator.equals("+")) {
                    currentNumber = plus_two_number(currentNumber, Integer.parseInt(token));
                    continue;
                }

                if (operator.equals("-")) {
                    currentNumber = minusTwoNumber(currentNumber, Integer.parseInt(token));
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 입력입니다. : " + e.getMessage());
                return 0;
            }
        }
        return currentNumber;
    }

    private static int minusTwoNumber(int currentNumber, int i) {
        return currentNumber - i;
    }

    private static int plus_two_number(int currentNumber, int i) {
        return currentNumber + i;
    }


}
