package stringcalculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String requestCalcInfo() {
        System.out.println("계산하실 문자열을 입력해주세요.");
        return scanner.nextLine();
    }
}
