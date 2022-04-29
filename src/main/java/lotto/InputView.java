package lotto;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int scan() {
        System.out.println("Put your money.");
        return scanner.nextInt();
    }
}
