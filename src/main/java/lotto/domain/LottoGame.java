package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int lottoPrice = 1000;

    public List<Lotto> createLotto(int money) {
        int count = money / lottoPrice;
        return LottoFactory.createLottos(count);
    }

    public List<Rank> getRankResults(WinningLotto winningLotto, List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(winningLotto.getRank(lotto));
        }
        return ranks;
    }

    public double calculateRateOfReturn(WinningLotto winningLotto, List<Lotto> lottos) {
        double money = lottoPrice * lottos.size();
        double sumOfReward = 0;
        for (Lotto lotto : lottos) {
            sumOfReward += winningLotto.getReward(lotto);
        }
        double rateOfReturn = sumOfReward / money;
        return Math.floor(rateOfReturn * 100) / 100;
    }


}
