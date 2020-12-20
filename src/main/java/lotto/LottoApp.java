package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoResult;
import lotto.domain.LottoNumber;
import lotto.domain.RandomLottoNumbersGenerator;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.Set;

public class LottoApp {

    public static void main(String[] args) {
        int buyAmount = InputView.scanBuyAmount();
        Set<LottoNumber> lottoNumbers = InputView.scanWinningNumbers();

        LottoCollection lottoCollection = new LottoCollection(buyAmount, new RandomLottoNumbersGenerator());
        LottoResult lottoResult = lottoCollection.getLottoResult(new Lotto(lottoNumbers));

        ResultView.printLottoNumberList(lottoCollection);
        ResultView.printStatistics(lottoResult);
    }

}
