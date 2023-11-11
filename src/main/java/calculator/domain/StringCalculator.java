package calculator.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String INVALID_OPERATION_MSG = "사칙연산 기호만 입력 할 수 있습니다.";
    private static final String NULL_EMPTY_MSG= "입력 값이 null 이거나 빈 공백 문자일 수 없습니다.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    public static final String SPACE = "";


    private Queue<Integer> operands;
    private Queue<Operation> operations;

    public StringCalculator(final String inputText) {
        validationCheck(inputText);

        final String[] tokens = inputText.split(SPACE);
        System.out.println("token");
        System.out.println(tokens.toString());
        for (String token : tokens) {
            System.out.println(token);

        }

        final Queue<Integer> operandQueue = new LinkedList<>();
        final Queue<Operation> operationQueue = new LinkedList<>();
        for (String token : tokens) {
            final Matcher numberMatcher = NUMBER_PATTERN.matcher(token);
            if (numberMatcher.find()) {
                operandQueue.add(Integer.valueOf(token));
                continue;
            }

            System.out.println(operandQueue.toString());

            if (!Operation.isOperation(token)) {
                throw new IllegalArgumentException(INVALID_OPERATION_MSG);
            }

            operationQueue.add(Operation.fromString(token));
            System.out.println(operationQueue.toString());

        }

        System.out.println("결과 " + operandQueue.toString());
        System.out.println("결과 " + operationQueue.toString());
        this.operations = operationQueue;
        this.operands = operandQueue;
    }

    private void validationCheck(final String inputText) {
        if (isNullOrEmpty(inputText)) {
            throw new IllegalArgumentException(NULL_EMPTY_MSG);
        }
    }


    private static boolean isNullOrEmpty(final String inputText) {
        return inputText == null || inputText.isBlank();
    }

    public int cal() {
        Integer result = operands.remove();
        System.out.println(result);
        System.out.println(operands.toString());
        System.out.println(operations.toString());

        System.out.println("=================");
        for (int i = 0 ; i < operations.size(); i ++) {
            final Operation op = operations.remove();
            final Integer operand = operands.remove();
            result = op.calculate(result, operand);
            System.out.println(operands.toString());
            System.out.println(operations.toString());
        }

        return result;
    }
}
