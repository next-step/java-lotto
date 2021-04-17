package step02.ui;

import java.util.Scanner;

import static step02.utils.LottoConfig.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return scanner.nextInt();
    }

    public static String inputLastWinnerNumber() {
        System.out.println(INPUT_LAST_WINNER_NUMBER);
        return scanner.next();
    }

    public static int inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL);
        return scanner.nextInt();
    }
}
