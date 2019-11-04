package lotto;

import lotto.domain.LottoPaper;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {

    public void execute() {
        int count = InputView.purchaseCount();
        LottoPaper lottoPaper = new LottoPaper(count);
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
        Map<Integer, Insights> insights = lottoPaper.getInsights();
        ResultView.printInsights(insights);
        ResultView.printYield(lottoPaper.getYield(count));
    }


}
