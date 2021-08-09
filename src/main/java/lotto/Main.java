package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int buyMoney = InputView.inputBuyMoney();

        List<Lotto> lottos = LottoMachine.buyRandomLotto(buyMoney);
        Game game = new Game(lottos);

        ResultView.resultLottoCount(game);
        ResultView.resultLottoNumbers(game);

        game.createRewards(InputView.inputPreviousLottoNumber(), InputView.inputBonusNumber());

        ResultView.resultLottoReward(game);
        ResultView.getYield(game);
    }
}
