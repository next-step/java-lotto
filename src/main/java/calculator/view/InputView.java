package calculator.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String inputCalculateString() {
        System.out.println("계산식을 입력하세요.");
        return scanner.nextLine();
    }
}
