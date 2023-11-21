package step1;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String readStringInput(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }
}
