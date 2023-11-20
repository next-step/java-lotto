package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        int purChaseCount = InputView.inputPurchaseCount();
        LottoList lottoList = new LottoList(purChaseCount);
        OutputView.printLottoList(lottoList);
        String winningNumbers = InputView.inputWinningNumbers();

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(new Lotto(winningNumbers));

        LottoResult lottoResult = new LottoResult(lottoList);
        LottoMatchResult lottoMatchResult = lottoResult.matchesWinningNumbers(lottoWinningNumbers);

        OutputView.printResultPhrase();
        OutputView.printMatchesResult(lottoMatchResult);
        OutputView.printRateOfReturn(lottoResult, lottoWinningNumbers);
    }
}
