package lotto;

public class LottoMain {
    public static void main(String[] args) {
        int amount;
        try {
            amount = InputView.getPurchaseAmount();
        } catch (RuntimeException e) {
            InputView.printInputError();
            return;
        }

        int totalCount = LottoPrice.getAvailableCount(amount);
        if (totalCount == 0) {
            InputView.printZeroCountError();
            return;
        }
        ResultView.printCount(totalCount);

        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.generateLotto(totalCount);
        ResultView.printLottoList(lottos);

        InputView.refreshLine();

        LottoNumbers winningNumbers;
        try {
            String numbers = InputView.getWinningNumbers();
            winningNumbers = new LottoNumbers(StringParser.parse(numbers));
        } catch (RuntimeException e) {
            InputView.printInputError();
            return;
        }

        LottoResult lottoResult = lottos.result(winningNumbers, amount);
        ResultView.printResult(lottoResult);
    }
}
