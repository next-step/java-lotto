package lotto.domain;

import java.util.Objects;

public class BonusNumber {
    private final LottoNumber lottoNumber;

    public BonusNumber(LottoNumbers lottoNumbers, int lottoNumber) {
        this.lottoNumber = new LottoNumber(lottoNumber);
        if (checkDuplication(lottoNumbers)) {
            throw new BonusNumberDuplicateException();
        }
    }

    public boolean isMatch(int lottoNumber) {
        return this.lottoNumber.equals(new LottoNumber(lottoNumber));
    }

    private boolean checkDuplication(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonusNumber)) return false;
        BonusNumber that = (BonusNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
