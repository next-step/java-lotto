package com.jaeyeonling.lotto.view;

import com.jaeyeonling.lotto.domain.Lotto;
import com.jaeyeonling.lotto.domain.LottoNumber;
import com.jaeyeonling.lotto.domain.Money;
import com.jaeyeonling.lotto.utils.StringToLottoTransfer;

import java.util.Scanner;

public final class ConsoleInputView {

    private static final String READ_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner CONSOLE = new Scanner(System.in);

    private ConsoleInputView() { }

    public static Money readMoney() {
        final int moneyValue = readIntWithMessage(READ_MONEY_MESSAGE);
        return new Money(moneyValue);
    }

    public static Lotto readWinningLotto() {
        ConsoleOutputView.newline();

        final String winningLottoValue = readStringWithMessage(READ_WINNING_LOTTO_NUMBER_MESSAGE);

        return StringToLottoTransfer.transform(winningLottoValue);
    }

    public static LottoNumber readBonusLottoNumber() {
        final int bonusLottoNumberValue = readIntWithMessage(READ_BONUS_LOTTO_NUMBER_MESSAGE);

        return new LottoNumber(bonusLottoNumberValue);
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
