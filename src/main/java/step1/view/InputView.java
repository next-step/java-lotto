package step1.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE = "사칙 연산을 입력하세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputText() {
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }

}
