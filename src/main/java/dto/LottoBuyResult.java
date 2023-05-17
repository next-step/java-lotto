package dto;

import domain.Lotto;
import domain.Money;

import java.util.Collections;
import java.util.List;

public class LottoBuyResult {
    private final List<Lotto> lottos;
    private final Money change;

    public LottoBuyResult(List<Lotto> lottos, Money change) {
        this.lottos = lottos;
        this.change = change;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Money getChange() {
        return change;
    }
}
