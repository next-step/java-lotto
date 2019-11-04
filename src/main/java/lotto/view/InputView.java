package lotto.view;

import lotto.domain.LottoGame;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MONEY_ERROR_MESSAGE = "%d 단위로 입력 해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int input = scanner.nextInt();
        scanner.nextLine();

        if (isGameMoneyUnit(input)) {
            System.err.println(String.format(INPUT_MONEY_ERROR_MESSAGE, LottoGame.GAME_AMOUNT));
            return inputMoney();
        }

        return input;
    }

    private static boolean isGameMoneyUnit(int input) {
        return input % LottoGame.GAME_AMOUNT != 0;
    }
}
