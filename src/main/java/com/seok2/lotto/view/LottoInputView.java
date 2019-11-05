package com.seok2.lotto.view;

import com.seok2.lotto.domain.Lotto;
import com.seok2.lotto.domain.LottoNumber;
import com.seok2.lotto.domain.Money;
import com.seok2.lotto.domain.WinningLotto;
import java.util.Scanner;

public class LottoInputView {

    private static final String PURCHASE_AMOUNT_MSG = "구매금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_MSG = "지난 주 당첨 번호를 입력해주세요.";
    private static final String WINNING_BONUS_NUMBER_MSG = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private LottoInputView() {
    }

    public static Money getInvestment() {
        System.out.println(PURCHASE_AMOUNT_MSG);
        return Money.of(scanner.nextInt());
    }

    public static WinningLotto getWinning() {
        System.out.println(WINNING_LOTTO_MSG);
        Lotto winning = Lotto.generate(scanner.next());
        System.out.println(WINNING_BONUS_NUMBER_MSG);
        return WinningLotto.of(winning, LottoNumber.of(scanner.nextInt()));
    }
}
