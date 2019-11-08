package com.seok2.lotto.view;

import com.seok2.lotto.domain.lotto.Lotto;
import com.seok2.lotto.domain.lotto.LottoNumber;
import com.seok2.lotto.domain.common.Money;
import com.seok2.lotto.domain.lotto.WinningLotto;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LottoInputView {

    private static final int ZERO_VALUE = 0;
    private static final String PURCHASE_AMOUNT_MSG = "구매금액을 입력해 주세요.";
    private static final String NUMBER_OF_MANUAL_NUMBER_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_NUMBER_MSG = "수동으로 구매할 번호를 입력해 주세요.";
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
        Lotto winning = Lotto.auto(scanner.next());
        System.out.println(WINNING_BONUS_NUMBER_MSG);
        return WinningLotto.of(winning, LottoNumber.of(scanner.nextInt()));
    }

    public static List<String> getLottoSheetRow() {
        System.out.println(NUMBER_OF_MANUAL_NUMBER_MSG);
        int trials = scanner.nextInt();
        if (trials <= ZERO_VALUE) {
            return Collections.emptyList();
        }
        System.out.println(MANUAL_NUMBER_MSG);
        return Stream.generate(scanner::next).limit(trials)
            .collect(Collectors.toList());
    }
}