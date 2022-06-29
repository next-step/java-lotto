package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private final SelectRule selectRule;

    public LottoMachine(SelectRule selectRule) {
        this.selectRule = selectRule;
    }

    public Lottos issue(Cash cash) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        BigDecimal lottoCount = cash.divide(Lotto.PRICE);
        for (int i = 0; lottoCount.compareTo(BigDecimal.valueOf(i)) > 0; i++) {
            lottoNumbersList.add(selectRule.select());
        }
        return new Lottos(new LottoNumbersList(lottoNumbersList));
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
