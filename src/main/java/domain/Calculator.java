package domain;

import java.util.Arrays;

public class Calculator {
    public static int calculate(String input) {
        int currentNumber = 0;
        String[] tokens = input.split(" ");


        for (String token : tokens) {
            if (token.equals("+")) {
                continue;
            }

            System.out.println("token : " + token);
            try {
                currentNumber += Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 입력입니다. : " + e.getMessage());
                return 0;
            }
        }
        return currentNumber;
    }
}
