package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_LOTTO_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private String inputStringValue() {
        return scanner.nextLine();
    }

    private int inputIntValue() {
        return scanner.nextInt();
    }

    public int inputLottoBuyAmount() {
        System.out.println(INPUT_LOTTO_BUY_AMOUNT);
        int amount = Integer.parseInt(inputStringValue());
        if (amount < 1000) {
            throw new RuntimeException("1000원보다 큰 금액을 입력하세요.");
        }
        return amount;
    }

    public String inputLastWeekWinnerNumbers() {
        System.out.println(INPUT_LAST_WEEK_WINNER_NUMBERS);
        return inputStringValue();
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return inputIntValue();
    }

    public void scannerClose() {
        scanner.close();
    }
}
