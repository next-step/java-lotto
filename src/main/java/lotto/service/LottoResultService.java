package lotto.service;

import lotto.domain.money.ImmutableMoney;
import lotto.domain.money.Money;
import lotto.domain.ProfitRate;
import lotto.domain.rank.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoWinner;
import lotto.domain.rank.RankMap;

import java.util.*;

public class LottoResultService {

    public RankMap checkLotto(final List<Lotto> lottos, final LottoWinner winner) {
        return new RankMap(lottos.stream().map(lotto -> winner.rank(lotto)).toArray(Rank[]::new));
    }

    public ProfitRate caculateProfitRate(final List<Lotto> lottos, final LottoWinner winner) {
        return new ProfitRate(reward(lottos, winner).money().divideValue(lottoPrice(lottos).value()));
    }

    private ImmutableMoney reward(final List<Lotto> lottos, final LottoWinner winner) {
        return checkLotto(lottos, winner).reward();
    }

    private ImmutableMoney lottoPrice(final List<Lotto> lottos) {
        Money lottoPrice = Lotto.LOTTO_PRICE.money();
        lottoPrice.multiply(lottos.size());
        return lottoPrice;
    }

}
