package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoConstraint;
import lotto.domain.Pick;
import lotto.domain.Prize;
import lotto.domain.enums.Rank;

import java.util.Collection;

public class LottoService {
    private final Lotto lotto;

    public LottoService(int price, LottoConstraint lottoConstraint, PrizePackager prizePackager) {
        lotto = new Lotto();
        lotto.setPrice(price);
        lotto.setConstraint(lottoConstraint);
        lotto.setPrize(prizePackager.pack());
    }

    public Integer getPrice() {
        return lotto.getPrice();
    }

    public LottoConstraint getConstraint() {
        return lotto.getConstraint();
    }

    public Rank checkRank(Pick pick, Collection<Integer> winningBalls) {
        return this.lotto.checkRank(pick, winningBalls);
    }

    public Prize getPrize(Rank rank) {
        return lotto.getPrize(rank);
    }
}
