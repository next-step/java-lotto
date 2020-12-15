package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoResult;
import lotto.domain.RandomNumberListGenerator;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Set;

public class LottoApp {

    public static void main(String[] args) {
        int buyAmount = InputView.scanBuyAmount();
        Set<Integer> numbers = InputView.scanWinningNumbers();

        LottoCollection lottoCollection = new LottoCollection(buyAmount, new RandomNumberListGenerator());
        LottoResult lottoResult = lottoCollection.getLottoResult(new Lotto(numbers));

        ResultView.printLottoNumberList(lottoCollection);
        ResultView.printStatistics(lottoResult);
    }

}
