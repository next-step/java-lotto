package lotto;

import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoGenerator lottoGenerator = new LottoGenerator();

        LottoStore lottoStore = new LottoStore(inputView, resultView, lottoGenerator);
        lottoStore.buy();
    }
}
