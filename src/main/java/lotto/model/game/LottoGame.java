package lotto.model.game;

import lotto.lottogenerator.LottoNumberPool;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.mylottos.MyLottos;
import lotto.model.result.EarningRate;
import lotto.model.result.GameResult;
import lotto.model.result.MatchingResult;
import lotto.model.winninglotto.WinningLotto;

import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private int autoLottoCount;
    private MyLottos myLottos;
    private WinningLotto winningLotto;

    public LottoGame(Money money) {
        autoLottoCount = money.findLottoCountToBuy();
    }

    public MyLottos start() {
        myLottos = LottoNumberPool.getMyLottos(autoLottoCount);
        return myLottos;
    }

    public GameResult getResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        return new GameResult(findCountOfNumbMatching(), findEarningRate());
    }

    private MatchingResult findCountOfNumbMatching() {
        Map<Rank, Long> result = new HashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, myLottos.findCountOfNumMatching(winningLotto, rank));
        }

        return new MatchingResult(result);
    }

    private EarningRate findEarningRate() {
        Double earningRate = myLottos.calculateEarningRate(winningLotto);
        return new EarningRate(earningRate);
    }
}