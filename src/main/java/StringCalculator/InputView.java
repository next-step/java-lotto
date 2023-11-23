package StringCalculator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputString(){
        System.out.println("계산식을 입력해주세요.");
        String cal = scanner.nextLine();
        return cal;
    }
}
