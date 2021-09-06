package lotto;

public class LottoMain {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int amount = InputView.getPurchaseAmount();

        LottoPrice lottoPrice = new LottoPrice();
        int totalCount = lottoPrice.getAvailableCount(amount);
        if (totalCount == 0) {
            InputView.printZeroCountError();
            return;
        }
        ResultView.printCount(totalCount);

        Lottos lottos = lottoGenerator.generateLotto(totalCount);
        ResultView.printLottoList(lottos);

        InputView.refreshLine();

        String numbers = InputView.getWinningNumbers();
        LottoNumbers winningNumbers = new LottoNumbers(StringParser.parse(numbers));
        LottoResult lottoResult = lottos.result(winningNumbers, amount);
        ResultView.printResult(lottoResult);
    }
}
