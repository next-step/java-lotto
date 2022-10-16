package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoReward;
import lotto.domain.LottoWinner;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public static final Money LOTTO_PRICE = new Money(1000);

    public int purchaseNumber(Money money) {
        return (int) money.divide(LOTTO_PRICE);
    }

    public List<Lotto> purchaseLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public Map<Integer, Integer> checkLotto(List<Lotto> lottos, LottoWinner winner) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 5; i >= 0; i--) {
            result.put(i, 0);
        }

        for (Lotto lotto : lottos) {
            int rank = winner.rank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    public double yield(List<Lotto> lottos, LottoWinner winner, Money money) {
        return new Money(reward(lottos, winner)).divide(money);
    }

    private long reward(List<Lotto> lottos, LottoWinner winner) {
        long result = 0;
        Map<Integer, Integer> lotto = checkLotto(lottos, winner);
        for (int i = 5; i >= 1; i--) {
            result += LottoReward.reward(i) * lotto.get(i);
        }
        return result;
    }
}
