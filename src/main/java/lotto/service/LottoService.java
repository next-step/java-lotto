package lotto.service;

import lotto.model.*;
import lotto.util.AwardNumberUtil;

import java.util.List;

public class LottoService {

    public List<Lotto> boughtAutoLotto(Guest guest, Store store) {
        return store.auto(guest.currentMoney());
    }

    public Lotto insertWinnerNumber(String winnerNumber) {
        return Lotto.from(AwardNumberUtil.getAwardNumberList(winnerNumber));
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
