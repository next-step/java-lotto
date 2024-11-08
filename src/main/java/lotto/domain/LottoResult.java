package lotto.domain;

import java.util.Map;
import java.util.Objects;

import static java.util.Collections.unmodifiableMap;

public class LottoResult {
    private final Map<LottoRank, Integer> resultMap;

    public LottoResult(Map<LottoRank, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public Map<LottoRank, Integer> getResultMap() {
        return unmodifiableMap(resultMap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(resultMap, that.resultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultMap);
    }
}
