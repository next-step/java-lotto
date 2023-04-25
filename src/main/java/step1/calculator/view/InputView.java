package step1.calculator.view;

import step1.calculator.domain.UserInput;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static UserInput getUserInput() {
        System.out.println("연산식을 입력하세요");
        String input = scanner.nextLine();
        return UserInput.of(input);
    }
}
