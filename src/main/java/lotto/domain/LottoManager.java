package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManager {

    private static final Long LOTTO_PRICE = 1000L;
    private final List<Lotto> lottos;

    public LottoManager(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoManager createLottoManagerByMoney(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.calculateQuantity(new Money(LOTTO_PRICE)); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return new LottoManager(lottos);
    }

    public LottoResult getResult(final WinningLotto winningLotto) {
        return new LottoResult(lottos.stream()
            .collect(Collectors.groupingBy(winningLotto::calculateRank, Collectors.counting())));
    }

    public double calculateYield(final WinningLotto winningLotto) {
        return getResult(winningLotto)
            .calculateTotalPrize()
            .calculateYield(calculatePurchaseAmount());
    }

    private Money calculatePurchaseAmount() {
        return new Money(lottos.size() * LOTTO_PRICE);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
