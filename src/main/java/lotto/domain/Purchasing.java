package lotto.domain;

import lotto.strategy.RandomNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Purchasing {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public Purchasing(Money money) {
        lottos = new ArrayList<>();
        for (int i = 0; i < money.divideMoney(LOTTO_PRICE); i++) {
            lottos.add(new Lotto(new RandomNumberStrategy()));
        }
    }

    public Map<WinningType, Integer> getWinningResult(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.matchWinningLotto(winningLotto))
                .collect(Collectors.toMap(winningType -> winningType, value -> 1, Integer::sum));
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
