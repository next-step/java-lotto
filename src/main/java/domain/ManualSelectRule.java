package domain;

import java.util.Objects;

public class ManualSelectRule implements SelectRule {
    private final LottoNumbersList manualLottoNumbers;
    private int selectCount;

    public ManualSelectRule(LottoNumbersList manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
        this.selectCount = 0;
    }

    @Override
    public boolean isSelectable() {
        return manualLottoNumbers.isSizeBiggerThan(selectCount);
    }

    @Override
    public LottoNumbers select() {
        if (isSelectable()) {
            LottoNumbers lottoNumbers = manualLottoNumbers.get(selectCount);
            selectCount++;
            return lottoNumbers;
        }
        throw new IllegalStateException("입력받은 수동 로또 개수를 초과해서 발행할 수 없습니다.");
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
