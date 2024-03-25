package controller.lotto;

import controller.lotto.view.LottoInputView;
import controller.lotto.view.LottoResultView;
import domain.common.Money;
import domain.lotto.LottoFactory;
import domain.lotto.UserLotto;
import domain.lotto.WinningLotto;
import domain.lotto.genrate.RandomGenerator;

import java.util.List;

public class LottoController {
    /**
     * 로또를 랜덤으로 구매한다.
     *
     * @param args
     */
    public static void main(String[] args) {
        Money money = Money.from(LottoInputView.createMoneyView());

        UserLotto userLotto = createUserLotto(money);

        LottoResultView.createUserLottoListView(userLotto.lottoList());

        WinningLotto winningLotto = createWinningLotto();

        LottoResultView.createStatisticsView(LottoStatistics.from(userLotto, winningLotto), money);

    }

    private static WinningLotto createWinningLotto() {
        List<Integer> winningIntegerList = LottoInputView.createWinningInterList();
        int bonusNumber = LottoInputView.createBonusNumberView();
        return WinningLotto.from(winningIntegerList, bonusNumber);
    }

    private static UserLotto createUserLotto(Money money) {
        LottoFactory lottoFactory = new LottoFactory(new RandomGenerator());
        return lottoFactory.createUserLotto(money);
    }
}
