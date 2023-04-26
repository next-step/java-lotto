package stringcalculator.domain;

import java.util.ArrayList;

public class Experssion {
    public static final String SPACE = " ";
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();

    public Experssion(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("수식이 입력되지 않았습니다.");
        }

        String[] elements = expression.split(SPACE);

        if (elements.length % 2 == 0) {
            throw new IllegalArgumentException("입력한 수식이 형식이 맞지 않거나, 지원하지 않는 연산자 입니다.");
        }

        for (int i = 0; i < elements.length; i++) {
            if (i % 2 == 0) {
                if (!elements[i].matches("\\d+")) {
                    throw new IllegalArgumentException("입력한 수식이 형식이 맞지 않거나, 지원하지 않는 연산자 입니다");
                }
                numbers.add(Integer.parseInt(elements[i]));
            }

            if (i % 2 != 0) {
                if (!elements[i].matches("[+\\-*/]")) {
                    throw new IllegalArgumentException("입력한 수식이 형식이 맞지 않거나, 지원하지 않는 연산자 입니다");
                }

                operators.add(elements[i]);
            }
        }
    }

    public int reduce() {
        int result = numbers.get(0).intValue();

        for (int i = 0; i < operators.size(); i++) {
            result = calculate(result, numbers.get(i+1).intValue(), operators.get(i));
        }

        return result;
    }

    private int calculate(int x, int y, String operator) {
        int result = 0;

        switch (operator) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
        }

        return result;
    }
}
