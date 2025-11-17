package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final String START_MESSAGE = "계산할 내용을 입력해주세요.(공백으로 구분해주세요)";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static String stringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
