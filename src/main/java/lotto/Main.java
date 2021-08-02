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

        List<Lotto> lottoList = LottoMachine.buyRandomLotto(buyMoney);
        Game game = new Game(lottoList);

        ResultView.resultLottoCount(game);
        ResultView.resultLottoNumbers(game);

        game.setPreviousLotto(InputView.inputPreviousLottoNumber());
        ResultView.resultLottoReward(game);
    }
}
