package calculator.view;

import calculator.domain.UserInput;

import java.util.Scanner;

public class InputView {

    private UserInput input;
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void createInput() {
        this.input = new UserInput(enterCalculatorInput());
    }

    private String enterCalculatorInput() {
        System.out.println("덧셈계산할 문자열을 입력해주세요.");
        return scanner.nextLine();
    }

    public UserInput getInput() {
        return input;
    }
}
