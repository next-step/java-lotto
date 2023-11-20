package lotto.ui;

import lotto.exception.MisMatchNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
        return inputNumber();
    }

    public int inputManualLottoCount() {
        System.out.println();
        System.out.println(INPUT_PURCHASE_MANUAL_LOTTO_COUNT);
        int manualLottoCount = inputNumber();
        scanner.nextLine();
        return manualLottoCount;
    }

    public void inputManualLottoInform() {
        System.out.println();
        System.out.println(INPUT_MANUAL_LOTTO);
    }

    public String inputManualLotto() {
        return scanner.nextLine();
    }

    public String inputWinningNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public int inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL);
        return inputNumber();
    }

    private int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            throw new MisMatchNumberException();
        }
    }

}
