package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> givenWinningLottoNumbers, Integer bonusNumber) {
        this(new Lotto(givenWinningLottoNumbers), LottoNumber.of(bonusNumber));
    }

    public WinningLotto(int[] givenWinningLottoNumbers, Integer bonusNumber) {
        this(new Lotto(Arrays.stream(givenWinningLottoNumbers)
                .boxed()
                .collect(Collectors.toList())), LottoNumber.of(bonusNumber));
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.containsLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("우승 번호와 보너스 번호는 같은 숫자가 있으면 안됩니다.");
        }
    }

    public Integer compareToMatchNumberCount(Lotto other) {
        return this.lotto.compareToMatchNumberCount(other);
    }

    public Boolean checkBonusNumber(Lotto other) {
        return other.containsLottoNumber(this.bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
