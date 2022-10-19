package step2.domain;

import java.util.Objects;

public class LottoNumberElement {
    private static final int MIN_LOTTO = 1;

    private static final int MAX_LOTTO = 45;

    protected final int lottoNumberElement;

    public LottoNumberElement(int lottoNumberElement) {
        validateLottoRange(lottoNumberElement);
        this.lottoNumberElement = lottoNumberElement;
    }

    protected void validateLottoRange(int lottoNumberElement) {
        if (lottoNumberElement > MAX_LOTTO || lottoNumberElement < MIN_LOTTO) {
            throw new IllegalArgumentException("로또 번호는 1~45여야 합니다. 입력한 번호: " + lottoNumberElement);
        }
    }

    protected int getLottoNumberElement() {
        return lottoNumberElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumberElement)) return false;
        LottoNumberElement that = (LottoNumberElement) o;
        return lottoNumberElement == that.lottoNumberElement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberElement);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumberElement);
    }
}
