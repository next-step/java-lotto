package lotto.model.game;

import lotto.lottogenerator.LottoGenerator;
import lotto.model.Money;
import lotto.model.lotto.MyLottos;
import lotto.model.gameresult.GameResult;
import lotto.model.winninglotto.WinningLotto;

public class LottoGame {
    private static MyLottos myLottos;

    public LottoGame() {
    }

    public static MyLottos start(Money money) {
        myLottos = new MyLottos(LottoGenerator.getLottos(money.findLottoCountToBuy()));
        return myLottos;
    }

    public static GameResult getResult(WinningLotto winningLotto) {
        return myLottos.findGameResult(winningLotto);
    }
}