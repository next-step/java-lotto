package domain;

import java.util.Objects;

public class LottoNumber {
    private final int value;
    public LottoNumber(final int value){
        if(value < 1 || value > 45){
            throw new IllegalArgumentException("로또번호는 1부터 45까지 입니다.");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
