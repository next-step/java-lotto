package step02.domain;

import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private final Map<LottoGrade, Integer> lottoGradeResultMap;

    public LottoResult(Map<LottoGrade, Integer> lottoGradeResultMap) {
        this.lottoGradeResultMap = lottoGradeResultMap;
    }

    public Map<LottoGrade, Integer> getLottoGradeResultMap() {
        return lottoGradeResultMap;
    }

    public int getTotalAmount() {
        return lottoGradeResultMap.keySet().stream()
            .mapToInt(lottoGrade -> lottoGrade.getWinnings() * lottoGradeResultMap.get(lottoGrade))
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
