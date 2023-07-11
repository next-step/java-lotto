package lottogame.domain;

import java.util.Objects;

public class LottoBonus {

    private final LottoNumber lottoNumber;

    LottoBonus(int bonusNumber, LottoNumbers lottoNumbers) {
        assertLottoNumber(bonusNumber, lottoNumbers);
        this.lottoNumber = LottoNumber.valueOf(bonusNumber);
    }

    private void assertLottoNumber(Integer bonusNumber, LottoNumbers lottoNumbers) {
        if (lottoNumbers.contains(LottoNumber.valueOf(bonusNumber))) {
            throw new IllegalArgumentException(
                String.format("bonusNumber \"%d\"는 lottoNumbers\"%s\"와 중복될 수 없습니다.", bonusNumber, lottoNumbers));
        }
    }

    boolean isContained(LottoNumbers lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, "lottoNumbers는 Null일 수 없습니다.");
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoBonus)) {
            return false;
        }
        LottoBonus that = (LottoBonus) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoBonus{" +
            "lottoNumber=" + lottoNumber +
            '}';
    }
}
