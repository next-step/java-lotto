package lotto.service;

import lotto.domain.Money.ImmutableMoney;
import lotto.domain.Money.Money;
import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.LottoReward;
import lotto.domain.lotto.LottoWinner;

import java.util.*;

public class LottoResultService {

    private final int LOTTO_MATCH_DEFAULT_COUNT = 0;

    public Map<Rank, Integer> checkLotto(final List<Lotto> lottos, final LottoWinner winner) {
        Map<Rank, Integer> result = getDefaultRankMap();
        for (Lotto lotto : lottos) {
            Rank rank = winner.rank(lotto);
            result.put(rank, result.getOrDefault(rank, LOTTO_MATCH_DEFAULT_COUNT) + 1);
        }
        return Collections.unmodifiableMap(result);
    }

    private Map<Rank, Integer> getDefaultRankMap() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, LOTTO_MATCH_DEFAULT_COUNT);
        }
        return result;
    }

    public double yield(final List<Lotto> lottos, final LottoWinner winner, final ImmutableMoney immutableMoney) {
        return reward(lottos, winner).money().divide(immutableMoney.value());
    }

    private ImmutableMoney reward(final List<Lotto> lottos, final LottoWinner winner) {
        Money result = new Money(0);
        Map<Rank, Integer> rankMap = checkLotto(lottos, winner);
        for (Rank rank : Rank.values()) {
            Money reward = LottoReward.reward(rank).money();
            reward.multiply(rankMap.get(rank));
            result.add(reward);
        }
        return result;
    }
}
