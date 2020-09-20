package lotto;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    public static void main(String...args){
        Money price = new Money(InputView.howMuchToBuy());
        Lottos lotto = Lottos.generateLottoList(price.getLottoCount());

        ResultView.printLottoCount(price.getLottoCount());
        ResultView.printLotto(lotto.getLottoList());

        WinningLotto winningLotto = new WinningLotto(InputView.winningNumber(), InputView.bonusNumber());

        LottoStore purchasedLotto = new LottoStore(lotto);
        purchasedLotto.matchNumber(winningLotto);

        ResultView.printWinningStatistics(purchasedLotto.getRankInfo());

        ResultView.printTotalYield(purchasedLotto.statistics(price));
    }
}
