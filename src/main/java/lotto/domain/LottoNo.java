package lotto.domain;

import java.util.Objects;

public class LottoNo {
    private Integer number;

    public LottoNo(Integer number) {
        this.number = number;
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
