package lotto.ui;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.shop.LottoPurchaseMoney;

import java.util.Scanner;

public class InputView {

    public static LottoPurchaseMoney inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        return LottoPurchaseMoney.input(money);
    }

    public static LottoTicket inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new LottoTicket(scanner.nextLine());
    }


}
