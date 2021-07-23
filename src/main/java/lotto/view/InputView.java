package lotto.view;

import lotto.money.Money;
import lotto.number.LottoNumber;
import lotto.number.WinningNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PAYMENT_STATEMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static Money inputPayment() {
        printStatement(INPUT_PAYMENT_STATEMENT);

        return Money.init(getInt());
    }

    public static WinningNumbers inputWinningNumbers() {
        printStatement(INPUT_WINNING_NUMBERS_STATEMENT);

        return Arrays.stream(readNumbers())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningNumbers::from));
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static int getInt() {
        return Integer.parseInt(
                SCANNER.nextLine()
                        .trim()
        );
    }

    private static String[] readNumbers() {
        return SCANNER.nextLine()
                .split(NUMBER_DELIMITER);
    }
}
