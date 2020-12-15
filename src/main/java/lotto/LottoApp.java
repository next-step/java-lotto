package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.RandomNumberListGenerator;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Set;

public class LottoApp {
    public static final int LOTTO_COST = 1000;

    public static void main(String[] args) {
        int buyAmount = InputView.scanBuyAmount();
        int lottoCount = convertLottoCount(buyAmount);

        Set<Integer> numbers = InputView.scanWinningNumbers();

        LottoCollection lottoCollection = new LottoCollection(lottoCount, new RandomNumberListGenerator());
        LottoResult lottoResult = lottoCollection.getLottoResult(new Lotto(numbers));

        ResultView.printLottoNumberList(lottoCollection);
        ResultView.printStatistics(lottoResult);
    }

    private static int convertLottoCount(int buyAmount) {
        return buyAmount / LOTTO_COST;
    }

}
