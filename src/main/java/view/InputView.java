package view;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    public static String expressionValue() {
        System.out.println("문자열 덧셈 수식을 입력해주세요");
        String value = scanner.nextLine();
        return replaceLinefeed(value);
    }

    private static String replaceLinefeed(String value) {
        if (StringUtils.isNotBlank(value) && value.contains("\\n")) {
            return value.replace("\\n", "\n");
        }

        return value;
    }
}
