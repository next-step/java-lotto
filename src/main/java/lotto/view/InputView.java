package lotto.view;


import java.util.Scanner;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.util.Console;

public class InputView {

    private InputView() {}

    public static LottoPrice readPrice() {
        OutputView.printRequestLottoPrice();
        try {
           LottoPrice price = new LottoPrice(Console.readLineInt());
           return price;
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            System.exit(0);
        }
        return readPrice();
    }

    public static String readWinningNumber() {
        OutputView.printWinningNumberBefore();
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
        OutputView.printBonusBallNumber();
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
