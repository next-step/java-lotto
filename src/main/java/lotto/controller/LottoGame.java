package lotto.controller;

import lotto.model.gameresult.GameResult;
import lotto.model.lottos.Lottos;
import lotto.model.Rank;
import lotto.model.winninglotto.WinningLotto;
import lotto.view.InputView;

import java.util.List;

public class LottoGame {
    private static Lottos myLottos;

    public static Lottos ready() {
        InputView.getMoneyFromUser();
        InputView.getManualLottoCountFromUser();
        myLottos = Lottos.getAllLottos(InputView.getLottoCountAuto(), InputView.getManualLottosFromUser());
        return myLottos;
    }

    public static GameResult start() {
        List<Rank> ranks = myLottos.match(getWinningLotto());
        return new GameResult(ranks);
    }

    private static WinningLotto getWinningLotto() {
        return new WinningLotto(
                InputView.getWinningLottoNumbersFromUser(),
                InputView.getBonusBallNumberFromUser()
        );
    }
}
