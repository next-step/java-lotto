package step2.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getFee() {
        System.out.println("구입금액을 입력하세요.");
        return scanner.nextInt();
    }
}
