package step02.ui;

import java.util.Scanner;

import static step02.utils.LottoConfig.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return SCANNER.nextInt();
    }

    public static String inputLastWinnerNumber() {
        System.out.println(INPUT_LAST_WINNER_NUMBER);
        return SCANNER.next();
    }

    public static int inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL);
        return SCANNER.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT);
        return SCANNER.nextInt();
    }

    public static String inputManualLotto(int count) {
        System.out.println(INPUT_MANUAL_NUMBER);
        return SCANNER.next();

    }
}
