package lotto.domain;

import java.util.Objects;
import lotto.domain.exception.BallException;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validation(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    LottoNumber(String lottoNumber) {
        this(Integer.parseInt(lottoNumber));
    }

    private void validation(int lottoNumber) {
        if (lottoNumber < 1) {
            throw new BallException("로또 번호는 1이상의 값을 가져야 합니다.");
        }
        if (lottoNumber > 45) {
            throw new BallException("로또 번호는 45이하의 값을 가져야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return this.lottoNumber == lottoNumber.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
            "ballNumber=" + lottoNumber +
            '}';
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
