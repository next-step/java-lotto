package step02.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private final Map<LottoGrade, Integer> lottoGradeResultMap = new HashMap<>();

    public LottoResult(Map<LottoGrade, Integer> lottoGradeResultMap) {
        this.lottoGradeResultMap.putAll(lottoGradeResultMap);
    }

    public Map<LottoGrade, Integer> getLottoGradeResultMap() {
        return Collections.unmodifiableMap(lottoGradeResultMap);
    }

    public long getTotalAmount() {
        return lottoGradeResultMap.keySet().stream()
            .mapToLong(lottoGrade -> (long) lottoGrade.getWinnings() * lottoGradeResultMap.get(lottoGrade))
            .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoResult)) {
            return false;
        }

        LottoResult that = (LottoResult) o;

        return Objects.equals(lottoGradeResultMap, that.lottoGradeResultMap);
    }

    @Override
    public int hashCode() {
        return lottoGradeResultMap != null ? lottoGradeResultMap.hashCode() : 0;
    }
}
