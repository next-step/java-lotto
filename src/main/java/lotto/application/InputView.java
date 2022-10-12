package lotto.application;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int purchase() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public String winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        SCANNER.nextLine();
        return SCANNER.nextLine();
    }

}
