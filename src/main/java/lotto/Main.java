package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PreviousLotto;
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

        PreviousLotto previousLotto = PreviousLotto.of(InputView.inputPreviousLottoNumber(), InputView.inputBonusNumber());
        game.match(previousLotto);

        ResultView.resultLottoReward(game);
        ResultView.getYield(game);
    }
}
