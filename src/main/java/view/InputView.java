package view;

import common.error.ErrorMessage;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = "\\s+";
    private final static String REQUEST_INPUT_GUIDE = "계산할 문자열을 입력해주세요.\n"
            + "입력 값은 공백 기준으로 분리되며 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정됩니다.\n"
            + "예시) 3 + 3 * 4  = 24";


    public static List<String> requestExpression() {
        String input = showPrompt(REQUEST_INPUT_GUIDE);
        validEmpty(input);

        return toList(input);
    }

    private static String showPrompt(String requestPrompt) {
        System.out.println(requestPrompt);
        return scanner.nextLine();
    }

    private static void validEmpty(String input) {

        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getErrorMessage());
        }

        if (input.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getErrorMessage());

        }
    }

    private static List<String> toList(String input) {
        return List.of(input.split(DELIMITER));
    }


}
