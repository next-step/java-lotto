package lotto.view;

import lotto.domain.LottoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MONEY_ERROR_MESSAGE = "%d 단위로 입력 해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_SELF_NUMBERS_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_SELF_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
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

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static int inputSelfNumberCount() {
        System.out.println(INPUT_SELF_NUMBERS_COUNT_MESSAGE);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static List<String> inputSelfNumber(int count) {
        System.out.println(INPUT_SELF_NUMBERS_MESSAGE);
        List<String> selfNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            selfNumbers.add(scanner.nextLine());
        }

        return selfNumbers;
    }
}
