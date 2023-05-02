package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static List<String> devide(String input) {
        return Arrays.stream(input.trim().split(" ")).collect(Collectors.toList());
    }

    public static int calculate(List<String> tokens) {
        int result = Integer.parseInt(tokens.get(0));
        String prev = "";
        tokens = tokens.subList(1, tokens.size());
        for (String token: tokens) {
            try {
                int number = Integer.parseInt(token);
                switch (prev) {
                    case "+":
                        result += number;
                        break;
                    case "*":
                        result *= number;
                        break;
                    case "-":
                        result -= number;
                        break;
                    case "/":
                        result /= number;
                        break;
                    default:
                        throw new RuntimeException("잘못된 입력입니다.");
                }
            } catch (NumberFormatException e) {
                prev = token;
            }
        }
        return result;
    }
}
