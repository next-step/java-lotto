package lotto.service;

import lotto.domain.*;
import lotto.domain.Money.ImmutableMoney;
import lotto.domain.Money.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.domain.LottoReward;
import lotto.domain.lotto.LottoWinner;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private final int LOTTO_MINIMUM_REWARD_RANK = 5;
    private final int LOTTO_FIRST_RANK = 1;
    private final int LOTTO_MATCH_DEFAULT_COUNT = 0;
    public static final ImmutableMoney LOTTO_PRICE = new ImmutableMoney(1000);

    public Amount purchaseNumber(final ImmutableMoney immutableMoney) {
        return new Amount(immutableMoney.money().divide(LOTTO_PRICE.value()).intValue());
    }

    public List<Lotto> purchaseLotto(final Amount amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount.amount(); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public List<Lotto> purchaseLotto(final List<LottoNumberSet> lottoNumberSetList) {
        return lottoNumberSetList.stream()
                .map(lottoNumberSet -> new Lotto(lottoNumberSet))
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> checkLotto(final List<Lotto> lottos, final LottoWinner winner) {
        Map<Integer, Integer> result = getDefaultRankMap();
        for (Lotto lotto : lottos) {
            int rank = winner.rank(lotto);
            result.put(rank, result.getOrDefault(rank, LOTTO_MATCH_DEFAULT_COUNT) + 1);
        }
        return Collections.unmodifiableMap(result);
    }

    private Map<Integer, Integer> getDefaultRankMap() {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = LOTTO_MINIMUM_REWARD_RANK; i >= LOTTO_FIRST_RANK; i--) {
            result.put(i, LOTTO_MATCH_DEFAULT_COUNT);
        }
        return result;
    }

    public double yield(final List<Lotto> lottos, final LottoWinner winner, final ImmutableMoney immutableMoney) {
        return reward(lottos, winner).money().divide(immutableMoney.value());
    }

    private ImmutableMoney reward(final List<Lotto> lottos, final LottoWinner winner) {
        Money result = new Money(0);
        Map<Integer, Integer> rankMap = checkLotto(lottos, winner);
        for (int i = LOTTO_MINIMUM_REWARD_RANK; i >= LOTTO_FIRST_RANK; i--) {
            Money reward = LottoReward.reward(i).money();
            reward.multiply(rankMap.get(i));
            result.add(reward);
        }
        return result;
    }
}
