package lotto.service;

import lotto.domain.lotto.LottoList;
import lotto.domain.money.Money;
import lotto.domain.ProfitRate;
import lotto.domain.rank.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoWinner;
import lotto.domain.rank.RankMap;

public class LottoResultService {

    public RankMap checkLotto(final LottoList lottos, final LottoWinner winner) {
        return new RankMap(lottos.lottoList().stream().map(lotto -> winner.rank(lotto)).toArray(Rank[]::new));
    }

    public ProfitRate caculateProfitRate(final LottoList lottos, final LottoWinner winner) {
        return new ProfitRate(reward(lottos, winner).divideValue(lottoPrice(lottos).money()));
    }

    private Money reward(final LottoList lottos, final LottoWinner winner) {
        return checkLotto(lottos, winner).reward();
    }

    private Money lottoPrice(final LottoList lottos) {
        return Lotto.LOTTO_PRICE.multiply(lottos.size());
    }

}
