package step02;

import java.util.Scanner;

import static step02.LottoConfig.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return scanner.nextInt();
    }

    public static String inputLastWinnerNumber() {
        System.out.println(INPUT_LAST_WINNER_NUMBER);
        return String.valueOf(scanner.nextInt());
    }
}
