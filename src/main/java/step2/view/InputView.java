package step2.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int init() {
        System.out.println("구입금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public String inputWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}
