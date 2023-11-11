package calculator.domain;

import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String INVALID_TOKEN_MSG = "올바른 입력이 아닙니다.";
    private static final String NULL_EMPTY_MSG= "입력 값이 null 이거나 빈 공백 문자일 수 없습니다.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern OPERATION_PATTERN = Pattern.compile("[+\\-*/]");
    public static final String SPACE = " ";

    private Queue<Integer> operands;
    private Operations operations;

    public StringCalculator(final String inputText) {
        validationInput(inputText);

        final String[] tokens = splitToken(inputText);

        final Queue<Integer> operandQueue = new LinkedList<>();

//        final Operations operations1 = new Operations(tokens);
//        System.out.println(operations1);

//        this.operations = operations1;
        this.operands = operandQueue;
    }

    private String[] splitToken(final String inputText) {
        final String[] tokens = inputText.split(SPACE);

        for (String token : tokens) {
            validationToken(token);
        }
        return tokens;
    }

    private void validationToken(final String token) {
        System.out.println("token");
        System.out.println(token);
        if (isNotNumberAndInvalidOperation(token)) {
            throw new IllegalArgumentException(INVALID_TOKEN_MSG);
        }
    }

    private boolean isNotNumberAndInvalidOperation(final String token) {
        return !NUMBER_PATTERN.matcher(token).find() && !OPERATION_PATTERN.matcher(token).find();
    }

    private void validationInput(final String inputText) {
        if (isNullOrEmpty(inputText)) {
            throw new IllegalArgumentException(NULL_EMPTY_MSG);
        }
    }


    private static boolean isNullOrEmpty(final String inputText) {
        return inputText == null || inputText.isBlank();
    }

    public int cal() {
        Integer result = operands.remove();

//        for (int i = 0 ; i < operations.size(); i ++) {
//            final Operation op = operations.remove();
//            final Integer operand = operands.remove();
//            result = op.calculate(result, operand);
//        }

        return result;
    }
}
