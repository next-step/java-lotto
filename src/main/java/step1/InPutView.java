package step1;

import java.util.Scanner;

public class InPutView {

    public static final String INPUT_TEXT = "숫자와 사칙연산을 입력하세요(공백으로 구분됩니다)";

    public static String input() {
        System.out.println(INPUT_TEXT);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
