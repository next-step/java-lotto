package view;

import java.util.Scanner;

public class Input {
    private static final String INPUT_OPERATION_EXPRESSION = "원하는 연산을 입력하세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static String express() {
        System.out.println(INPUT_OPERATION_EXPRESSION);
        String str = sc.nextLine();
        if (str == null | str.isBlank()) {
            throw new IllegalArgumentException("공백은 올 수 없습니다.");
        }
        return str;
    }
}
