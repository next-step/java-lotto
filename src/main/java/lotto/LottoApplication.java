package lotto;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoList lottoList = generateLottoList();
        LottoWinningNumbers lottoWinningNumbers = generateLottoWinningNumbers();

        LottoResult lottoResult = new LottoResult(lottoList);
        LottoMatchResult lottoMatchResult = lottoResult.matchesWinningNumbers(lottoWinningNumbers);

        printResult(lottoResult, lottoMatchResult, lottoWinningNumbers);
    }

    public static LottoList generateLottoList() {
        int purChaseCount = InputView.inputPurchaseCount();
        List<String> manualLotto = InputView.inputManualLotto();
        LottoList lottoList = new LottoList(purChaseCount - manualLotto.size(), manualLotto);
        OutputView.printLottoList(lottoList, manualLotto.size());

        return lottoList;
    }

    public static LottoWinningNumbers generateLottoWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        String bonusNumber = InputView.inputBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(
                new Lotto(winningNumbers), new LottoNumber(bonusNumber)
        );

        return lottoWinningNumbers;
    }

    public static void printResult(LottoResult lottoResult,
                                   LottoMatchResult lottoMatchResult,
                                   LottoWinningNumbers lottoWinningNumbers) {
        OutputView.printResultPhrase();
        OutputView.printMatchesResults(lottoMatchResult);
        OutputView.printRateOfReturn(lottoResult, lottoWinningNumbers);
    }
}
