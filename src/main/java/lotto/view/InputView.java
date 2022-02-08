package lotto.view;


import java.util.Scanner;
import lotto.domain.LottoNumber;
import lotto.util.Console;

public class InputView {

    private InputView() {}

    public static int readPrice() {
        int price = 0;
        try {
            price = Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            System.exit(0);
        }
        return price;
    }

    public static String readWinningNumber() {
        String winningNumber = "";
        Scanner sc = new Scanner(System.in);
        try {
            winningNumber = sc.nextLine();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            System.exit(0);
        }
        return winningNumber;
    }

    public static LottoNumber readBonusNumber() {
        int bonusNumber = 0;
        try {
            bonusNumber = Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(OutputView.ERROR_MESSAGE + exception.getMessage());
            System.exit(0);
        }
        return new LottoNumber(bonusNumber);
    }
}
