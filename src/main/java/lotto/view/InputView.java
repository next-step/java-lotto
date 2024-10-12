package lotto.view;

import lotto.domain.number.Lotto;
import lotto.domain.sales.LottoBill;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    public LottoBill lottoBill() {
        System.out.println("구입 금액을 입력해주세요.");
        int money = SCANNER.nextInt();
        LottoBill bill = new LottoBill(money);
        System.out.println(bill.quantity() + "개를 구매했습니다.");
        clear();
        return bill;
    }

    public Lotto lastWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(SCANNER.nextLine());
    }

    private void clear() {
        if (SCANNER.hasNextLine()) {
            SCANNER.nextLine();
        }
    }
}
