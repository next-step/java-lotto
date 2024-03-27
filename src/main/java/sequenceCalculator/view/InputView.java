package sequenceCalculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputSequence() {
        System.out.println("문자열을 입력하세요 :");
        return scanner.nextLine();
    }

}
