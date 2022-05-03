package study.step1.view;

import study.step1.domain.Formula;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_INFORMATION_MESSAGE = "계산할 수식을 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Formula inputStringFromUser() {
        System.out.println(INPUT_INFORMATION_MESSAGE);
        return Formula.from(scanner.nextLine());
    }
}
