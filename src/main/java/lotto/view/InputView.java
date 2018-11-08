package lotto.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    
    public static int inputTryNo(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
    
    public static String inputTryLine(String message) {
        System.out.println(message);
        return scanner.next();
    }
}
