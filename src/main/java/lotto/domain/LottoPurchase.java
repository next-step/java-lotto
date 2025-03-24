package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.Pair;

public class LottoPurchase {

    private static final Money LOTTO_PRICE = new Money(1000);

    private final Money money;
    private final int lottoSize;
    private final Money change;
    private final List<Lotto> lottos;

    public LottoPurchase(Money money) {
        this.money = money;
        Pair<Money> pair = money.divAndMod(LOTTO_PRICE);
        this.lottoSize = pair.getLeft().getValue();
        this.change = pair.getRight();
        this.lottos = createLottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public BigDecimal getRoi(Money totalPrize) {
        Money invest = this.money.sub(change);

        return BigDecimal.valueOf(totalPrize.getValue())
            .divide(BigDecimal.valueOf(invest.getValue()), 2, RoundingMode.HALF_UP);
    }

    private List<Lotto> createLottos() {
        return IntStream.range(0, this.lottoSize)
            .mapToObj(i -> LottoFactory.createAuto())
            .collect(Collectors.toList());
    }
}
