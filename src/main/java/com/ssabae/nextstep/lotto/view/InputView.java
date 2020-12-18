package com.ssabae.nextstep.lotto.view;

import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.WinningNumber;
import java.util.Scanner;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class InputView {

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static Money buyMoneyInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_AMOUNT_MESSAGE);
        long amount = scanner.nextLong();
        return Money.won(amount);
    }

    public static WinningNumber winningNumberInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumberString = scanner.nextLine();
        return new WinningNumber(winningNumberString);
    }
}
