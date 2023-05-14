package step2.view.inputView;

import java.util.Scanner;

public class InputView {

    public static String inputString(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }

    public static int inputNumber(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextInt();
    }
}
