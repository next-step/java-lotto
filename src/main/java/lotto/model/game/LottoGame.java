package lotto.model.game;

import lotto.lottogenerator.LottoNumberPool;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.mylottos.MyLottos;
import lotto.model.gameresult.EarningRate;
import lotto.model.gameresult.GameResult;
import lotto.model.gameresult.MatchingResult;
import lotto.model.winninglotto.WinningLotto;

import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private int autoLottoCount;
    private MyLottos myLottos;

    public LottoGame(Money money) {
        autoLottoCount = money.findLottoCountToBuy();
    }

    public LottoGame(int autoLottoCount, MyLottos myLottos) {
        this.autoLottoCount = autoLottoCount;
        this.myLottos = myLottos;
    }

    public MyLottos start() {
        myLottos = LottoNumberPool.getMyLottos(autoLottoCount);
        return myLottos;
    }

    public GameResult getResult(WinningLotto winningLotto) {
        return myLottos.findGameResult(winningLotto);
    }
}