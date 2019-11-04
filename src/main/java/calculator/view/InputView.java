package calculator.view;

import java.util.Scanner;

public class InputView {

    private String inputValue;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        this.inputValue = enterCalculatorInput(scanner);
    }

    private String enterCalculatorInput(Scanner scanner) {
        System.out.println("덧셈계산할 문자열을 입력해주세요.");
        return scanner.nextLine();
    }

    public String getInputValue() {
        return inputValue;
    }
}
