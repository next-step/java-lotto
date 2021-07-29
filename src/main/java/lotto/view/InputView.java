package lotto.view;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_STATEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static Money inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);

        return Money.of(changeIntInputValue());
    }

    public static WinningLotto inputWinningNumbers() {
        printStatement(INPUT_WINNING_NUMBERS_STATEMENT);

        return WinningLotto.of(
                LottoNumbers.of(Arrays.stream(readNumbers())
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .mapToObj(LottoNumber::of)
                        .collect(Collectors.toList())));
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static String[] readNumbers() {
        return scanner.nextLine()
                .split(NUMBER_DELIMITER);
    }

    private static int changeIntInputValue() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
