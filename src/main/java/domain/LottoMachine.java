package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private final SelectRule selectRule;

    public LottoMachine(SelectRule selectRule) {
        this.selectRule = selectRule;
    }

    public Lottos issue(Cash cash) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = cash.divide(Lotto.PRICE);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(selectRule.select()));
        }
        return new Lottos(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMachine that = (LottoMachine) o;
        return selectRule.equals(that.selectRule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectRule);
    }
}
