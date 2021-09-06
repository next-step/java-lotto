package lotto;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.getPurchaseAmount();
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

        String numbers = InputView.getWinningNumbers();
        LottoNumbers winningNumbers = new LottoNumbers(StringParser.parse(numbers));
        LottoResult lottoResult = lottos.result(winningNumbers, amount);
        ResultView.printResult(lottoResult);
    }
}
