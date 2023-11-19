package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        int purChaseCount = InputView.inputPurchaseCount();
        LottoList lottoList = new LottoList(purChaseCount);
        String winningNumbers = InputView.inputWinningNumbers();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new Lotto(winningNumbers));

        LottoResult lottoResult = new LottoResult(lottoList);
        lottoResult.matchesWinningNumbers(lottoWinningNumbers);

        OutputView.printResultPhrase();
        OutputView.printResult(lottoResult);
    }
}
