package lotto;

import lotto.domain.LottoPaper;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void execute() {
        int count = InputView.purchaseCount();
        LottoPaper lottoPaper = new LottoPaper(count);
        printLottoNumber(lottoPaper);
        List<Rank> ranks = getWinLotto(lottoPaper);


    }

    private void printLottoNumber(LottoPaper lottoPaper) {
        ResultView.printLottoNumber(lottoPaper);
    }

    private List<Rank> getWinLotto(LottoPaper lottoPaper) {
        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        return lottoPaper.getWinningLottoRanks(winLotto, bonusNumber);
    }


}
