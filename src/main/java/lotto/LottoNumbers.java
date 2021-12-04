package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<LottoNumber> values;

    public LottoNumbers(List<LottoNumber> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "values=" + values +
                '}';
    }
}
