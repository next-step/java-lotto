package com.jaeyeonling.lotto.view;

import com.jaeyeonling.lotto.config.Env;
import com.jaeyeonling.lotto.domain.Lotto;
import com.jaeyeonling.lotto.domain.LottoNumber;
import com.jaeyeonling.lotto.domain.Money;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class ConsoleInputView {

    private static final Scanner CONSOLE = new Scanner(System.in);

    private ConsoleInputView() { }

    public static Money readMoney() {
        final int moneyValue = readIntWithMessage(Env.READ_MONEY_MESSAGE);
        return new Money(moneyValue);
    }

    public static Lotto readWinningLotto() {
        ConsoleOutputView.newline();
        final String winningLottoValue = readStringWithMessage(Env.READ_WINNING_LOTTO_NUMBER_MESSAGE);

        final Set<LottoNumber> lottoNumbers = Arrays.stream(splitWinningLottoNumber(winningLottoValue))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }

    private static String[] splitWinningLottoNumber(final String winningLottoNumber) {
        return winningLottoNumber.split(Env.WINNING_LOTTO_NUMBER_SEPARATOR);
    }

    private static String readStringWithMessage(final String message) {
        ConsoleOutputView.print(message);
        return readString();
    }

    private static String readString() {
        return CONSOLE.nextLine();
    }

    private static int readIntWithMessage(final String message) {
        ConsoleOutputView.print(message);
        return readInt();
    }

    private static int readInt() {
        final int readValue = CONSOLE.nextInt();
        CONSOLE.nextLine();

        return readValue;
    }
}
