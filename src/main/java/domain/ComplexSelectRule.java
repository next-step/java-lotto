package domain;

import java.util.Objects;

public class ComplexSelectRule implements SelectRule {
    private final LottoNumbersList manualLottoNumbers;
    private final SelectRule selectRule;
    private int selectCount;

    public ComplexSelectRule(LottoNumbersList manualLottoNumbers, SelectRule selectRule) {
        this.manualLottoNumbers = manualLottoNumbers;
        this.selectRule = selectRule;
        this.selectCount = 0;
    }

    @Override
    public LottoNumbers select() {
        LottoNumbers lottoNumbers = selectRule.select();
        if (manualLottoNumbers.isSizeBiggerThan(selectCount)) {
            lottoNumbers = manualLottoNumbers.get(selectCount);
        }
        selectCount++;
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexSelectRule that = (ComplexSelectRule) o;
        return selectCount == that.selectCount && manualLottoNumbers.equals(that.manualLottoNumbers) && selectRule.equals(that.selectRule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoNumbers, selectRule, selectCount);
    }
}
