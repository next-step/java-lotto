package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPaper;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;

public class LottoController {

    public void execute() {
        LottoPaper lottoPaper = new LottoPaper();
        int count = InputView.purchaseCount();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lotto.selectLottoNumber();
            lottoPaper.applyLotto(lotto);
        }

        ResultView.printLottoNumber(lottoPaper);

        int[] winLotto = InputView.getWinLotto();

        lottoPaper.checkLottoGrade(winLotto);

        ResultView.printInsights(lottoPaper);
    }


}
