package step1.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MESSAGE = "계산할 식을 입력하세요.";

    public static String input() {
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
