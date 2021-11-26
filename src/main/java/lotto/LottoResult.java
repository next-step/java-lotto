package lotto;

import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Prize, Integer> value;

    public LottoResult(Map<Prize, Integer> value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
