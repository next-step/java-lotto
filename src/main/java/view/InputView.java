package view;

import java.util.Scanner;

public class InputView {

    public static String showExpressionInput() {
        System.out.println("수식 입력 > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
