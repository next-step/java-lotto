package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static int LOTTO_SIZE = 6;
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

    public int[] checkLotto(List<Lotto> lottos, Lotto winner) {
        int[] matchList = new int[LOTTO_SIZE + 1];
        for (Lotto lotto : lottos) {
            matchList[winner.match(lotto)]++;
        }
        return matchList;
    }

    public double yield(List<Lotto> lottos, Lotto winner, Money money) {
        return new Money(reward(lottos, winner)).divide(money);
    }

    private int reward(List<Lotto> lottos, Lotto winner) {
        int result = 0;
        int[] ints = checkLotto(lottos, winner);
        for (int i = 3; i < LOTTO_SIZE; i++) {
            result += LottoReward.values()[LOTTO_SIZE - i].reward() * ints[i];
        }
        return result;
    }
}
