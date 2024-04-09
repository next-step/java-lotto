package controller;

import domain.*;

import java.util.List;

public class LottoController {

    private LottoMachine lottoMachine = new LottoMachine();
    private MyLotto myLotto = new MyLotto();
    private WinStatus winStatus = new WinStatus();
    private final int BASIC_LOTTO_BALL_COUNT = 6;

    public MyLotto totalLotto(TotalTry totalTry) {
        for (int i = 0; i < totalTry.getTotalTry(); i++) {
            List<LottoBall> nowLotto = lottoMachine.randomBall(BASIC_LOTTO_BALL_COUNT);
            myLotto.add(nowLotto);
        }
        return myLotto;
    }

    public WinStatus resultReturn(Lotto winLotto) {
        for (Lotto currentLotto  : myLotto.getLotto()) {
            int price = currentLotto.parseNumber(winLotto);
            if (price == 6)
                price = isBonusMatch(currentLotto, winLotto);
            winStatus.correct(price);
        }
        return winStatus;
    }

    private int isBonusMatch(Lotto currentLotto, Lotto winLotto) {
        for (LottoBall ball : currentLotto.getBalls()) {
            if (winLotto.getBalls().contains(ball))
                return 6;
        }
        return 7;
    }
}
