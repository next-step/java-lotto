package step1.controller.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "사칙연산을 입력 해주세요";

    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public String inputExpression() {
        return scanner.nextLine();
    }

}
