package step1.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String getCalculatorSign() {
        System.out.print("계산식을 입력하세요 = ");
        return scanner.next();
    }
}
