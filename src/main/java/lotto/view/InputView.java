package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningNumbers;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNINGNUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNINGNUMBER_DELIMITER = ", ";

    public PurchaseMoney inputPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int purchaseMoney = toInt(SCANNER.nextLine());

        return new PurchaseMoney(purchaseMoney);
    }

    public WinningNumbers inputLastWeekWinningNumbers() {
        System.out.println(INPUT_WINNINGNUMBERS_MESSAGE);
        List<Integer> lastWeekWinningNumbers = split(SCANNER.nextLine());

        return new WinningNumbers(lastWeekWinningNumbers);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    private List<Integer> split(String input) {
        return Arrays.stream(input.split(WINNINGNUMBER_DELIMITER))
            .map(this::toInt)
            .collect(toList());
    }
}
