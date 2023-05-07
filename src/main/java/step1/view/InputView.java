package step1.view;

import java.util.Scanner;

public class InputView {
    public static String inputString(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }
}
