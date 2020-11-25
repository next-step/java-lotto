package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoBalls;
import lotto.domain.Pick;
import lotto.domain.Prize;
import lotto.domain.enums.Rank;

import java.util.Map;

public class LottoService {
    private final Lotto lotto;

    public LottoService(int price, AbstractPrizePackager prizePackager) {
        lotto = new Lotto(price, prizePackager.pack());
    }

    public Integer getPrice() {
        return lotto.getPrice();
    }

    public Rank checkRank(Pick pick, LottoBalls winningBalls) {
        return this.lotto.checkRank(pick, winningBalls);
    }

    public Map<Rank, Prize> getPrizeMap() {
        return lotto.getPrizeMap();
    }
}
