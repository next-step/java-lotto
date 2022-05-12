package lotto.service;

import lotto.model.*;
import lotto.util.AwardNumberUtil;

import java.util.List;

public class LottoService {

    public Lottos boughtAutoLotto(Guest guest, Store store) {
        return store.auto(guest.currentMoney());
    }

    public Lotto insertWinnerNumber(String winnerNumber) {
        return Lotto.asWinnerLotto(AwardNumberUtil.getAwardNumbers(winnerNumber));
    }

    public void holdingLotteryTickets(List<Lotto> lottoProducts, Lotto winLotto, int bonus) {
        new LotteryTickets(lottoProducts).findGrade(winLotto, bonus);
    }

    public double yieldCalculate(long money) {
        return LotteryResults.yield(money);
    }

    public Integer insertBonusNumber(int bonus) {
        return bonus;
    }
}
