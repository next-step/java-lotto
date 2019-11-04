package com.seok2.lotto.view;

import com.seok2.lotto.domain.Lotto;
import com.seok2.lotto.domain.Money;

import java.util.Scanner;

public class LottoInputView {

    private static final String PURCHASE_AMOUNT_MSG = "구매금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_MSG = "지난 주 당첨 번호를 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static Money getMoney() {
        System.out.println(PURCHASE_AMOUNT_MSG);
        return Money.of(scanner.nextInt());
    }

    public static Lotto getWinning() {
        System.out.println(WINNING_LOTTO_MSG);
        return Lotto.generate(scanner.next());
    }
}
