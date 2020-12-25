package com.ssabae.nextstep.lotto.view;

import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.WinningNumber;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class InputView {

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKET_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKET_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static Money buyMoneyInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_AMOUNT_MESSAGE);
        long amount = scanner.nextLong();
        return Money.won(amount);
    }

    public static List<String> manualTicketInput() {
        int ticketCountInput = manualTicketCountInput();
        return manualTicketNumberInput(ticketCountInput);
    }

    private static int manualTicketCountInput() {
        System.out.println(INPUT_MANUAL_TICKET_COUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static List<String> manualTicketNumberInput(int count) {
        System.out.println(INPUT_MANUAL_TICKET_MESSAGE);
        return Stream.generate(() -> new Scanner(System.in).nextLine())
                .limit(count)
                .collect(Collectors.toList());
    }

    public static WinningNumber winningNumberInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumberString = scanner.nextLine();

        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumberString = scanner.nextLine();

        return new WinningNumber(winningNumberString, bonusNumberString);
    }
}
