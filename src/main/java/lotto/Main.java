package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {
    private static final LottoPrice LOTTO_PRICE = new LottoPrice(1000);

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(LOTTO_PRICE);
        int purchasePrice = InputView.queryPurchasePrice();
        Lotto lotto = lottoStore.purchase(purchasePrice);
        ResultView.printLotto(lotto);

        LottoNumbers winningNumbers = LottoNumbers.of(InputView.queryWinningNumbers());
        LottoNumber bonusNumber = InputView.queryBonusNumber();
        WinningLotto winingLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<LottoResult> results = lotto.match(winingLotto);
        LottoResultStat resultStat = new LottoResultStat(results);
        double profitMargin = resultStat.getProfitMargin(LOTTO_PRICE);
        ResultView.printLottoResults(resultStat);
        ResultView.printProfitMargin(profitMargin);
    }
}
