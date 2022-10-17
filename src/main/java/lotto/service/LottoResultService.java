package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Money.ImmutableMoney;
import lotto.domain.Money.Money;
import lotto.domain.ProfitRate;
import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.LottoReward;
import lotto.domain.lotto.LottoWinner;

import java.util.*;

public class LottoResultService {

    public Map<Rank, Amount> checkLotto(final List<Lotto> lottos, final LottoWinner winner) {
        Map<Rank, Amount> result = getDefaultRankMap();
        for (Lotto lotto : lottos) {
            Rank rank = winner.rank(lotto);
            result.get(rank).add(new Amount(1));
        }
        return Collections.unmodifiableMap(result);
    }

    private Map<Rank, Amount> getDefaultRankMap() {
        Map<Rank, Amount> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, new Amount(0));
        }
        return result;
    }

    public ProfitRate caculateProfitRate(final List<Lotto> lottos, final LottoWinner winner) {
        return new ProfitRate(reward(lottos, winner).money().divide(lottoPrice(lottos).value()));
    }

    private ImmutableMoney reward(final List<Lotto> lottos, final LottoWinner winner) {
        Money result = new Money(0);
        Map<Rank, Amount> rankMap = checkLotto(lottos, winner);
        for (Rank rank : Rank.values()) {
            Money reward = LottoReward.reward(rank).money();
            reward.multiply(rankMap.get(rank).amount());
            result.add(reward);
        }
        return result;
    }

    private ImmutableMoney lottoPrice(final List<Lotto> lottos) {
        Money lottoPrice = Lotto.LOTTO_PRICE.money();
        lottoPrice.multiply(lottos.size());
        return lottoPrice;
    }

}
