package calculator.domain;

import java.util.*;

public class Parser {
    public static List<String> split(String text) {
        String[] splitText = text.split(" ");
        return Arrays.asList(splitText);
    }

    public static Deque<Integer> numberParsing(List<String> texts) {
        Deque<Integer> numbers = new ArrayDeque<>();

        for(int evenIndex = 0; evenIndex < texts.size(); evenIndex += 2) {
            int number = parseNumberFormat(texts.get(evenIndex));
            numbers.addLast(number);
        }

        return numbers;
    }

    public static Deque<String> operatorParsing(List<String> texts) {
        Deque<String> operators = new ArrayDeque<>();
        for(int oddIndex = 1; oddIndex < texts.size(); oddIndex += 2) {
            operatorCheck(texts.get(oddIndex));
            operators.addLast(texts.get(oddIndex));
        }

        return operators;
    }
    private static int parseNumberFormat(String numberString) {
        try {
            int result = Integer.parseInt(numberString);
            return result;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다", e);
        }
    }

    private static void operatorCheck(String operator) {
        if (!OperatorEnum.contains(operator)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    public static boolean emptyValidate(String text) {
        if (empty(text)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        return true;
    }

    private static boolean empty(String text) {
        return text == null || text.isBlank();
    }
}
