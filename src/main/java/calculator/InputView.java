package calculator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String getUserOperation() {
        System.out.println("연산식을 입력 해 주세요.");
        return scanner.nextLine();
    }
}
