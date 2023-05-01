package stringCalculator.view;

import java.util.Scanner;

public class InputView {

    private static final String OPERATE_OF_MESSAGE = "사칙연산 문자열을 입력해주세요. ";
    private Scanner INPUT;

    public InputView(Scanner scanner) {
        this.INPUT = scanner;
    }

    public String setOperateText() {
        System.out.println(OPERATE_OF_MESSAGE);

        return INPUT.nextLine();
    }
}
