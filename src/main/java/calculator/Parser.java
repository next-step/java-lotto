package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Parser {
    private static final List<String> operators = Arrays.asList("+", "-", "*", "/");
    public static List<String> split(String text) {
        String[] splitText = text.split(" ");
        return Arrays.asList(splitText);
    }

    public static Stack<Integer> numberParsing(List<String> texts) {
        Stack<Integer> numbers = new Stack<>();

        for (int index = texts.size() - 1; index >= 0; index--) {
            if (index % 2 ==  0) {
                try {
                    int result = Integer.parseInt(texts.get(index));
                    numbers.push(result);
                } catch (NumberFormatException e){
                    throw new IllegalArgumentException("숫자가 아닙니다", e);
                }
            }
        }
        return numbers;
    }

    public static Stack<String> operatorParsing(List<String> texts) {
        Stack<String> oprators = new Stack<>();

        for (int index = texts.size() - 1; index >= 0; index--) {
            if (index % 2 ==  1) {
                if (!operators.contains(texts.get(index))) {
                    throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
                }
                oprators.push(texts.get(index));
            }
        }

        return oprators;
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
