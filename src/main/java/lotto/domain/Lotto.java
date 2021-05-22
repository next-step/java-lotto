package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class Lotto {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final long PRICE = 1_000L;

    private final LottoNumbers lottoNumbers;
    private final LottoType lottoType;

    public Lotto(LottoNumbers lottoNumbers, LottoType lottoType) {
        this.lottoNumbers = lottoNumbers;
        this.lottoType = lottoType;
    }

    public static Lotto auto() {
        return new Lotto(LottoNumbersGenerator.generate(), LottoType.AUTO);
    }

    public static Lotto manual(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers, LottoType.MANUAL);
    }

    public Set<LottoNumber> getNumbers() {
        return lottoNumbers.getValue();
    }

    public WinningType match(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return WinningType.findType(countOfMatch(winningNumbers), isBonusMatch(bonusNumber));
    }

    private int countOfMatch(LottoNumbers winningNumbers) {
        return lottoNumbers.matchNumbers(winningNumbers);
    }

    private boolean isBonusMatch(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public boolean isAuto() {
        return LottoType.isAuto(this.lottoType);
    }

    public boolean isManual() {
        return LottoType.isManual(this.lottoType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers) &&
                lottoType == lotto.lottoType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, lottoType);
    }
}
