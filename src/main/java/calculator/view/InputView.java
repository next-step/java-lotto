package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTION_START = "계산식을 입력 하세요";
    public static String inputData() {
        System.out.println(QUESTION_START);
        return SCANNER.nextLine();
    }
}
