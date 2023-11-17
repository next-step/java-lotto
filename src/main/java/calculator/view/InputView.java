package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputCalculateValue() {
        System.out.println("값을 입력하세요.");
        return SCANNER.nextLine();
    }

}
