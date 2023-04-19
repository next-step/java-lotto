package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static int difference(int num1, int num2) {
        return num1 - num2;
    }

    public static int quotient(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수로 떨어지지 않습니다.");
        }
        return num1 / num2;
    }

    public static int product(int num1, int num2) {
        return num1 * num2;
    }

    public static int calculate(String input) {
        if (!StringUtils.hasText(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String[] tokens = input.split(" ");
        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(tokens[i]));
            } else {
                if (
                    tokens[i].equals("+")
                    || tokens[i].equals("-")
                    || tokens[i].equals("*")
                    || tokens[i].equals("/")
                ) {
                    operators.add(tokens[i]);
                } else {
                    throw new IllegalArgumentException("잘못된 연산자가 포함되어 있습니다.");
                }
            }
        }
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("+")) {
                result = sum(result, numbers.get(i + 1));
            } else if (operators.get(i).equals("-")) {
                result = difference(result, numbers.get(i + 1));
            } else if (operators.get(i).equals("*")) {
                result = product(result, numbers.get(i + 1));
            } else if (operators.get(i).equals("/")) {
                result = quotient(result, numbers.get(i + 1));
            }
        }

        return result;
    }
}
