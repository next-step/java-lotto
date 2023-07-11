package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public LottoResult getResult(final WinningLotto winningLotto) {
        return new LottoResult(lottos.stream()
            .collect(Collectors.groupingBy(winningLotto::calculateRank, Collectors.counting())));
    }

    public double calculateYield(final WinningLotto winningLotto) {
        LottoResult result = getResult(winningLotto);
        return result.calculateTotalPrize() / ((long) lottos.size() * LOTTO_PRICE);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
