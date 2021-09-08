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

        List<Integer> winningNumbers = inputWinningNumbers();
        if (winningNumbers == null) {
            InputView.printInputError();
            return;
        }

        Lotto winningLotto = LottoGenerator.generateManualLotto(winningNumbers);
        ResultView.printResult(lottos.result(winningLotto, amount));
    }

    private static List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;
        try {
            String numbers = InputView.getWinningNumbers();
            winningNumbers= StringParser.parseIntList(numbers);
        } catch (NumberFormatException e) {
            return null;
        }
        return winningNumbers;
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
}
