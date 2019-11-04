package step2.view;

import step2.domain.LottoTicket;

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

    public LottoTicket getLastWeekWinningNumber() {
        return new LottoTicket();
    }
}
