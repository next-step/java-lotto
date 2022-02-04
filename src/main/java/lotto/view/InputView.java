package lotto.view;


import lotto.util.Console;

public class InputView {

    private InputView() {
    }

    public static int readPrice() {
        int price = 0;
        try {
            price = Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
        }
        return price;
    }

    public static String readWinningNumber() {
        String winningNumber = "";
        try {
            winningNumber = Console.readLine();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
        }
        return winningNumber;
    }

    public static int readBonusNumber() {
        int bonusNumber = 0;
        try {
            bonusNumber = Console.readLineInt();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
        }
        return bonusNumber;
    }
}
