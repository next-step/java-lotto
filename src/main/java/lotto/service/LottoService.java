package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoConstraint;
import lotto.domain.enums.Rank;

public class LottoService {
    private final Lotto lotto;

    public LottoService(int price, LottoConstraint lottoConstraint) {
        lotto = new Lotto();
        lotto.setPrice(price);
        lotto.setConstraint(lottoConstraint);
    }

    public Integer getPrice() {
        return lotto.getPrice();
    }

    public LottoConstraint getConstraint() {
        return lotto.getConstraint();
    }

    public void addPrize(Rank rank, Long prize) {
        lotto.addToPrizeMap(rank, prize);
    }

    public Long getPrize(Rank rank) {
        return lotto.getPrizeMap().get(rank);
    }
}
