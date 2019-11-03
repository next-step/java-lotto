package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPaper;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void execute() {
        LottoPaper lottoPaper = new LottoPaper();
        int count = InputView.purchaseCount();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lotto.selectLottoNumber();
            lottoPaper.applyLotto(lotto);
        }
        printLottoNumber(lottoPaper);
        getWinLotto(lottoPaper);
        getInsights(lottoPaper, count);

    }

    private void printLottoNumber(LottoPaper lottoPaper) {
        ResultView.printLottoNumber(lottoPaper);
    }

    private void getWinLotto(LottoPaper lottoPaper) {
        int[] winLotto = InputView.getWinLotto();
        lottoPaper.checkLottoGrade(winLotto);
    }

    private void getInsights(LottoPaper lottoPaper, int count) {
        ResultView.printDescription();
        lottoPaper.getInsights();
        ResultView.printInsights();
        ResultView.printYield(lottoPaper.getYield(count));
    }


}
