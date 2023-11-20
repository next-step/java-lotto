package step1;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readStringInput(String msg) {
        System.out.println(msg);
        return scanner.next();
    }

    private InputView() {
    }

}
