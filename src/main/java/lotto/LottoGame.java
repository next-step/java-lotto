package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    public static void main(String...args){
        Money price = new Money(InputView.howMuchToBuy());
        List<Lotto> lotto = LottoGenerator.generateLottoList(price.getLottoCount());

        ResultView.printLottoCount(price.getLottoCount());
        ResultView.printLotto(lotto);

        WinningLotto winningLotto = new WinningLotto(InputView.winningNumber());

        LottoStore purchasedLotto = new LottoStore(lotto);
        purchasedLotto.matchNumber(winningLotto.getWinningLotto());

        ResultView.printWinningStatistics(purchasedLotto.getRankInfo());

        ResultView.printTotalYield(purchasedLotto.statistics(price));
    }
}
