package step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 적어도" + MIN_LOTTO_NUMBER + "이상이어야 합니다.");
        }

        if (lottoNumber > MAX_LOTTO_NUMBER ) {
            throw new IllegalArgumentException("로또 번호는 최대" + MAX_LOTTO_NUMBER + "초과해서는 안됩니다.");
        }

        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.lottoNumber - other.lottoNumber;
    }
}
