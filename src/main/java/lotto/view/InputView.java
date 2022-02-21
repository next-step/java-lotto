package lotto.view;

import java.util.Scanner;
import lotto.util.Console;

public class InputView {

    private InputView() {}

    public static int readPrice() {
        OutputView.printRequestLottoPrice();
        try {
           return Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            return readPrice();
        }
    }

    public static String readWinningNumber() {
        OutputView.printWinningNumberBefore();
        Scanner sc = new Scanner(System.in);
        try {
            String winningNumber = sc.nextLine();
            return winningNumber;
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            return readWinningNumber();
        }
    }

    public static int readBonusNumber() {
        OutputView.printBonusBallNumber();
        try {
           return Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            return readBonusNumber();
        }
    }
}
