package lotto.view;


import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.util.Console;

public class InputView {

    private InputView() {}

    public static int readPrice() {
        try {
           int price = Console.readLineInt();
           return price;
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            System.exit(0);
        }
        return readPrice();
    }

    public static String readWinningNumber() {
        Scanner sc = new Scanner(System.in);
        try {
            String winningNumber = sc.nextLine();
            return winningNumber;
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            System.exit(0);
        }
        return readWinningNumber();
    }

    public static LottoNumber readBonusNumber() {
        try {
           int bonusNumber = Console.readLineInt();
           return new LottoNumber(bonusNumber);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            System.exit(0);
        }
        return readBonusNumber();
    }
}
