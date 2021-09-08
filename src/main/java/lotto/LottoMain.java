package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int amount = inputAmount();
        if (amount <= 0) {
            InputView.printInputError();
            return;
        }

        int totalCount = LottoPrice.getAvailableCount(amount);
        if (totalCount <= 0) {
            InputView.printZeroCountError();
            return;
        }
        ResultView.printCount(totalCount);

        Lottos lottos = LottoGenerator.generateAutoLottos(totalCount);
        ResultView.printLottoList(lottos);
        InputView.refreshLine();

        String numbers = inputWinningNumbers();
        List<Integer> winningNumbers = parseIntList(numbers);
        if (winningNumbers == null) {
            InputView.printInputError();
            return;
        }
        Lotto winningLotto = LottoGenerator.generateManualLotto(winningNumbers);

        int number = inputBonusNumber();
        if (number <= 0) {
            InputView.printInputError();
            return;
        }
        LottoNumber bonusNumber = new LottoNumber(number);

        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);
        ResultView.printResult(lottos.result(winningNumber, amount));
    }

    private static String inputWinningNumbers() {
        return InputView.getWinningNumbers();
    }

    private static List<Integer> parseIntList(String numbers) {
        List<Integer> numberList;
        try {
            numberList = StringParser.parseIntList(numbers);
        } catch (NumberFormatException e) {
            return null;
        }
        return numberList;
    }

    private static int inputAmount() {
        int amount;
        try {
            amount = InputView.getPurchaseAmount();
        } catch (RuntimeException e) {
            return -1;
        }
        return amount;
    }

    private static int inputBonusNumber() {
        int bonusNumber;
        try {
            bonusNumber = InputView.getBonusNumber();
        } catch (RuntimeException e) {
            return -1;
        }
        return bonusNumber;
    }
}
