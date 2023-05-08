package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int inputCostOfLotto() {
        Scanner scanner = new Scanner(System.in);
        int costOfLotto = scanner.nextInt();
        return costOfLotto;
    }

    public static String inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        String winningNumber = scanner.nextLine();
        return winningNumber;
    }

    public static int inputBonusBallNumber() {
        Scanner scanner = new Scanner(System.in);
        int bonusBallNumber = scanner.nextInt();
        return bonusBallNumber;
    }
}
