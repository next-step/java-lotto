package calculator.ui;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MSG = "계산식을 입력해주세요: ";

    public static void print(){
        System.out.println(INPUT_MSG);
    }

    public static String input(){
        return scanner.nextLine();
    }
}
