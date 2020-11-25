package step2.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getFee() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}
