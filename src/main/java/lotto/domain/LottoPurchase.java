package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.Pair;

public class LottoPurchase {

    private final Money purchaseAmount;
    private final Money change;
    private final List<Lotto> lottos;
    private final int manualSize;

    public LottoPurchase(Money purchaseAmount, Money change, List<Lotto> lottos, int manualSize) {
        this.purchaseAmount = purchaseAmount;
        this.change = change;
        this.lottos = Collections.unmodifiableList(lottos);
        this.manualSize = manualSize;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAutoSize() {
        return this.lottos.size() - manualSize;
    }

    public int getManualSize() {
        return manualSize;
    }

    public BigDecimal getRoi(Money totalPrize) {
        Money invest = this.purchaseAmount.sub(change);

        return BigDecimal.valueOf(totalPrize.getValue())
            .divide(BigDecimal.valueOf(invest.getValue()), 2, RoundingMode.HALF_UP);
    }
}
