package calculation;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.println("계산식을 입력해주세요.");
        String text = scanner.nextLine();

        if (!isNullOrBlank(text)) {
            return text;
        }
        
        return null;
    }

    public static boolean isNullOrBlank(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("null이거나 빈 공백 문자열입니다.");
        }
        return false;
    }


}
