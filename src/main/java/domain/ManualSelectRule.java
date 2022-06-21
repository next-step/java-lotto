package domain;

import java.util.Objects;

public class ManualSelectRule implements SelectRule {
    private final LottoNumbersList manualLottoNumbers;
    private final RandomSelectRule randomSelectRule;
    private int selectCount;

    public ManualSelectRule(LottoNumbersList manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
        this.randomSelectRule = new RandomSelectRule();
        this.selectCount = 0;
    }

    @Override
    public LottoNumbers select() {
        if (manualLottoNumbers.isSmallerThanSize(selectCount)) {
            return manualLottoNumbers.get(selectCount);
        }
        return randomSelectRule.select();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualSelectRule that = (ManualSelectRule) o;
        return selectCount == that.selectCount && manualLottoNumbers.equals(that.manualLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoNumbers, selectCount);
    }
}
