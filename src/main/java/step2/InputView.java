package step2;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String requestMoneyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public String requestYourNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
