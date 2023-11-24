package lotto;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purChaseCount = InputView.inputPurchaseCount();
        List<String> manualLotto = InputView.inputManualLotto();
        LottoList lottoList = new LottoList(purChaseCount - manualLotto.size(), manualLotto);
        OutputView.printLottoList(lottoList, manualLotto.size());
        String winningNumbers = InputView.inputWinningNumbers();
        String bonusNumber = InputView.inputBonusNumber();

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
                new Lotto(winningNumbers), new LottoNumber(bonusNumber)
        );

        LottoResult lottoResult = new LottoResult(lottoList);
        LottoMatchResult lottoMatchResult = lottoResult.matchesWinningNumbers(lottoWinningNumbers);

        OutputView.printResultPhrase();
        OutputView.printMatchesResults(lottoMatchResult);
        OutputView.printRateOfReturn(lottoResult, lottoWinningNumbers);
    }
}
