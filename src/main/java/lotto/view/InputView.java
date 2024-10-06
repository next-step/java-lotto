package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoBill;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    public LottoBill sell() {
        System.out.println("구입 금액을 입력해주세요.");
        int money = SCANNER.nextInt();
        LottoBill bill = new LottoBill(money);
        System.out.println(bill.quantity() + "개를 구매했습니다.");
        return bill;
    }

    public Lotto lastWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lastWinning = SCANNER.nextLine();
        return Lotto.of(lastWinning);
    }
}
