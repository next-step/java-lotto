package calculator.view;

import java.util.Scanner;

public class Input {
    private static final String INPUT_OPERATION_EXPRESSION = "원하는 연산을 입력하세요.";
    private static final String ERROR_CHECK_SPACE = "공백은 올 수 없습니다.";
    private static final Scanner sc = new Scanner(System.in);

    public static String express() {
        System.out.println(INPUT_OPERATION_EXPRESSION);
        String str = sc.nextLine();
        checkSpace(str);
        return str;
    }

    private static void checkSpace(String str) {
        if (str == null | str.isBlank()) {
            throw new IllegalArgumentException(ERROR_CHECK_SPACE);
        }
    }
}
