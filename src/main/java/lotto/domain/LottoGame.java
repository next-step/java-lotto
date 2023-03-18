package lotto.domain;

import java.util.*;

public class LottoGame {
    public static final Money LOTTO_PRICE = new Money(1000);

    private final List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoGame(Money lottoPay) {
        int count = lottoPay.division(LOTTO_PRICE).toInteger();
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            this.lottos.add(Lotto.lottery());
        }
    }

    public List<Lotto> getAllLottos() {
        return this.lottos;
    }

    public WinningStatistics getStatistics(WinningNumbers winningNumbers) {
        return new WinningStatistics(winningNumbers, lottos);
    }

    public Money getBuyPrice() {
        return LOTTO_PRICE.multiply(this.lottos.size());
    }

    public int getBuyCount() {
        return lottos.size();
    }
}
