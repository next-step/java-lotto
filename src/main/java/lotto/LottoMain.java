package lotto;

public class LottoMain {
    public static void main(String[] args) {
        int amount = inputAmount();
        if (amount < 0) return;

        int totalCount = calculateCount(amount);
        if (totalCount < 0) return;
        ResultView.printCount(totalCount);

        Lottos lottos = getLottos(totalCount);
        ResultView.printLottoList(lottos);

        InputView.refreshLine();

        LottoNumbers winningNumbers = inputWinningNumbers();
        if (winningNumbers == null) return;

        ResultView.printResult(lottos.result(winningNumbers, amount));
    }

    private static LottoNumbers inputWinningNumbers() {
        LottoNumbers winningNumbers;
        try {
            String numbers = InputView.getWinningNumbers();
            winningNumbers = new LottoNumbers(StringParser.parse(numbers));

            int bonusNumber = StringParser.parseInt(InputView.getBonusNumber());
        } catch (NumberFormatException e) {
            InputView.printInputError();
            return null;
        }
        return winningNumbers;
    }

    private static Lottos getLottos(int totalCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateLotto(totalCount);
    }

    private static int calculateCount(int amount) {
        int totalCount = LottoPrice.getAvailableCount(amount);
        if (totalCount == 0) {
            InputView.printZeroCountError();
            return -1;
        }
        return totalCount;
    }

    private static int inputAmount() {
        int amount;
        try {
            amount = InputView.getPurchaseAmount();
        } catch (RuntimeException e) {
            InputView.printInputError();
            return -1;
        }
        return amount;
    }
}
