package StringCalculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String Input() {
        System.out.println("계산 식 입력 :");
        return scanner.nextLine();
    }
}
