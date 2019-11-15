package lotto.domain;

import java.util.Objects;

public class LottoNo {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    private Integer number;

    public LottoNo(Integer number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (this.number > LOTTO_MAX_NUMBER || this.number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException("잘 못된 로또 숫자 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return Objects.equals(number, lottoNo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Integer getNumber() {
        return number;
    }
}
