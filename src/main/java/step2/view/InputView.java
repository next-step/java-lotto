package step2.view;

import java.util.Scanner;

public class InputView {
    Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return sc.nextInt();
    }

    public String getLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return sc.next();
    }
}
