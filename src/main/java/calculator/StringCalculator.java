package calculator;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringCalculator {
    // 숫자로 나타낼 수 있는 문자열인지 확인하기 위한 패턴
    private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    // 피연산자 스택과 연산자 스택
    private static final Stack<Integer> NUMSTACK = new Stack<>();
    private static final Stack<String> SIGNSTACK = new Stack<>();

    // 수로 나타낼 수 있는 문자열인지
    private boolean isNumeric;

    // 연산자 스택이 비어있는지
    private boolean isSignEmpty;

    public int calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
        if (!isOdd(input)) {
            throw new IllegalArgumentException("입력한 식이 잘못되었습니다.");
        }

        isRightOrder(input);

        return getResult(input);
    }

    private int getResult(String input) {
        for (String token : split(input)) {
            isNumeric = isNumeric(token);
            isSignEmpty = isSignEmpty();

            // 숫자가 아닌 경우 경우 : 연산자 스택에 push
            if (!isNumeric) {
                pushSignStack(token);
            }
            // 숫자이고 연산자 스택이 비어있는 경우 : 피연산자 스택에 push
            if (isNumeric && isSignEmpty) {
                pushNumStack(parseInt(token));
            }
            // 숫자이고 연산자 스택이 비어있지 않은 경우 : 연산 결과를 피연산자 스택에 push
            if (isNumeric && !isSignEmpty) {
                pushNumStack(apply(popNumStack(), parseInt(token), popSignStack()));
            }
        }
        return peekNumStack();
    }

    private boolean isBlank(String expression) {
        return expression.isBlank();
    }

    private boolean isOdd(String input) {
        return split(input).length % 2 != 0;
    }

    private void isRightOrder(String input) {
        String[] tokens = split(input);
        exploreEven(tokens);
        exploreOdd(tokens);
    }

    private void exploreOdd(String[] tokens) {
        IntStream.range(0, tokens.length)
                .filter(index -> index % 2 != 0)
                .forEach(index -> {
                    if (isNumeric(tokens[index])) {
                        throw new IllegalArgumentException("잘못된 숫자/연산자 나열입니다.");
                    }
                });
    }

    private void exploreEven(String[] tokens) {
        IntStream.range(0, tokens.length)
                .filter(index -> index % 2 == 0)
                .forEach(index -> {
                    if (!isNumeric(tokens[index])) {
                        throw new IllegalArgumentException("잘못된 숫자/연산자 나열입니다.");
                    }
                });
    }

    public int apply(int num1, int num2, String textOperator) {
        return Operator.checkOperator(textOperator).operate(num1, num2);
    }

    private void pushSignStack(String str) {
        SIGNSTACK.push(str);
    }

    private void pushNumStack(int number) {
        NUMSTACK.push(number);
    }

    private String popSignStack() {
        return SIGNSTACK.pop();
    }

    private int popNumStack() {
        return NUMSTACK.pop();
    }

    private boolean isSignEmpty() {
        return SIGNSTACK.isEmpty();
    }

    private int peekNumStack() {
        return NUMSTACK.peek();
    }

    private String[] split(String expression) {
        return expression.split(" ");
    }

    private boolean isNumeric(String input) {
        return PATTERN.matcher(input).matches();
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }
}