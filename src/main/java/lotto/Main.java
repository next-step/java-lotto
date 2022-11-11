package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int purchasePrice = InputView.queryPurchasePrice();
        int manualCount = InputView.queryManualPurchaseCount();

        Lotto lotto = getLotto(purchasePrice, manualCount);
        WinningLotto winingLotto = getWinningLotto();

        List<LottoResult> results = lotto.match(winingLotto);
        showResult(results);
    }

    private static Lotto getLotto(int purchasePrice, int manualCount) {
        List<LottoNumbers> autoNumbers = LottoStore.purchaseAuto(purchasePrice, manualCount);
        List<LottoNumbers> manualNumbers = InputView.queryManualLottoNumbers(manualCount).stream()
                .map(LottoNumbers::of)
                .collect(Collectors.toList());

        ResultView.printPurchaseCount(manualCount, autoNumbers.size());
        Lotto lotto = new Lotto(manualNumbers, autoNumbers);
        ResultView.printLotto(lotto);
        return lotto;
    }

    private static WinningLotto getWinningLotto() {
        LottoNumbers winningNumbers = LottoNumbers.of(InputView.queryWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(InputView.queryBonusNumber());
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private static void showResult(List<LottoResult> results) {
        LottoResultStat resultStat = new LottoResultStat(results);
        double profitMargin = resultStat.getProfitMargin(LottoStore.LOTTO_PRICE);
        ResultView.printLottoResults(resultStat);
        ResultView.printProfitMargin(profitMargin);
    }
}
