package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchasePrice = InputView.queryPurchasePrice();
        if (purchasePrice <= LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액이 너무 작습니다.");
        }
        int autoCount = purchasePrice / LOTTO_PRICE;
        int manualCount = InputView.queryManualPurchaseCount();

        Lotto lotto = getLotto(autoCount, manualCount);
        WinningLotto winingLotto = getWinningLotto();

        List<LottoResult> results = lotto.match(winingLotto);
        showResult(results);
    }

    private static Lotto getLotto(int autoCount, int manualCount) {
        InputView.printQueryManualLottoNumbersMessage();
        Lotto lotto = LottoStore.purchase(manualCount, autoCount,
                () -> LottoNumbers.of(InputView.queryLottoNumbers()));
        ResultView.printPurchaseCount(manualCount, autoCount);
        ResultView.printLotto(lotto);
        return lotto;
    }

    private static WinningLotto getWinningLotto() {
        InputView.printQueryWinningNumbersMessage();
        LottoNumbers winningNumbers = LottoNumbers.of(InputView.queryLottoNumbers());
        LottoNumber bonusNumber = InputView.queryBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private static void showResult(List<LottoResult> results) {
        LottoResultStat resultStat = new LottoResultStat(results);
        double profitMargin = resultStat.getProfitMargin(LOTTO_PRICE);
        ResultView.printLottoResults(resultStat);
        ResultView.printProfitMargin(profitMargin);
    }
}
