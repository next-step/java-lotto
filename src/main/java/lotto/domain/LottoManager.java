package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public LottoManager(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoManager createLottoManagerByMoney(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return new LottoManager(lottos);
    }

    public Map<LottoRank, Long> getResult(final WinningLotto winningLotto) {
        return lottos.stream()
            .collect(Collectors.groupingBy(winningLotto::calculateRank, Collectors.counting()));
    }

    public double calculateYield(final WinningLotto winningLotto) {
        Map<LottoRank, Long> result = getResult(winningLotto);
        double total = result.keySet()
            .stream()
            .mapToDouble(key -> key.getPrize() * result.get(key))
            .sum();
        return total / (lottos.size() * LOTTO_PRICE);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
