package step1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArithmeticExpression {

    private static final Pattern EXPRESSION_VALIDATE = Pattern.compile(
        "^\\s*(:?(?!.+/ ?0.*)\\d+ *?[+\\-*/] *?)+\\d+\\s*$");
    private static final Pattern DIVIDE_ZERO = Pattern.compile("/ +0+");
    private static final String CUT_NUMBERS = "(?<number>[0-9])\\s*([+\\-*/])";
    private static final String CUT_OPERATOR = "(\\d)(?<operator>[+\\-*/])";

    private final String input;

    public ArithmeticExpression(String input) {
        validation(input);
        this.input = input;
    }


    private void validation(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("최소한 1개의 숫자를 입력하셔야 합니다.");
        }
        if (DIVIDE_ZERO.matcher(input).find()) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        if (!EXPRESSION_VALIDATE.matcher(input).find()) {
            throw new IllegalArgumentException("잘못된 연산식입니다.");
        }
    }

    public Numbers numbers() {
        String[] splitNumber = input
            .replaceAll(" ", "")
            .replaceAll(CUT_NUMBERS, "${number} ")
            .split(" ");

        List<Number> numberList = Arrays.stream(splitNumber)
            .map(Number::new)
            .collect(Collectors.toList());

        return new Numbers(numberList);
    }

    public Operators operators() {
        String[] splitOperator = input.replaceAll(" ", "")
            .replaceAll(CUT_OPERATOR, "${operator}")
            .replaceAll("\\d", "")
            .split("");

        List<Operator> operatorList = Arrays.stream(splitOperator)
            .map(operator -> new Operator(operator.charAt(0)))
            .collect(Collectors.toList());

        return new Operators(operatorList);
    }
}
