package step1.calculator.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("문자열을 입력해주세요.");
        return scanner.nextLine();
    }

}
