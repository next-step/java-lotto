package lotto.controller;

import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.gameresult.GameResult;
import lotto.model.lottos.Lottos;
import lotto.model.winninglotto.WinningLotto;
import lotto.view.InputView;

import java.util.List;

public class LottoGame {
    public static Lottos ready() {
        Money money = InputView.getMoney();
        int manualLottoCount = InputView.getManualLottoCount(money);
        int autoLottoCount = money.getLottoCount() - manualLottoCount;

        return Lottos.createAllLottos(
                autoLottoCount,
                InputView.getManualLottos(manualLottoCount)
        );
    }

    public static GameResult start(Lottos lottos) {
        List<Rank> ranks = lottos.match(getWinningLotto());
        return new GameResult(ranks);
    }

    private static WinningLotto getWinningLotto() {
        return new WinningLotto(
                InputView.getWinningLottoNumbers(),
                InputView.getBonusBallNumber()
        );
    }
}