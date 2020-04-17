package lotto.view;

import lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String WINNING_DELIMITER = ", ";

    private static final String MONEY_INPUT_NOTICE = "구입금액을 입력해 주세요.";
    private static final String MONEY_INVALID_NOTICE = "1000원 이상의 금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_NOTICE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_NOTICE = "보너스 볼을 입력해 주세요.";

    private static final int MONEY_DEFAULT = 0;
    private static final int MONEY_MIN = 1000;
    private static final int DEFAULT_NUMBER = -1;

    public static int getMoney() {
        int money;
        do {
            System.out.println(MONEY_INPUT_NOTICE);
            money = parseMoney();
        } while (!isValidMoney(money));

        return money;
    }

    private static int parseMoney() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return MONEY_DEFAULT;
        }

    }

    private static boolean isValidMoney(int money) {
        if (money < MONEY_MIN) {
            System.out.println(MONEY_INVALID_NOTICE);
            return false;
        }

        return true;
    }

    public static WinningNumbers getWinnerNumber() {
        System.out.println(WINNING_NUMBER_NOTICE);

        return getWinningNumbers(scanner.nextLine());
    }

    private static WinningNumbers getWinningNumbers(String winningInput) {
        String[] inputs = winningInput.split(WINNING_DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        return WinningNumbers.getInstance(winningNumbers, InputView.getBonusNumber());
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_NOTICE);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return DEFAULT_NUMBER;
        }
    }
}
