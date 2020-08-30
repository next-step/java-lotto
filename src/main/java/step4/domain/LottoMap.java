package step4.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LottoMap {
    private final Map lottoMap;

    public LottoMap(Map lottoMap) {
        this.lottoMap = lottoMap;
    }

    public Map getLottoMap() {
        return lottoMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMap that = (LottoMap) o;
        return Objects.equals(lottoMap, that.lottoMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMap);
    }
}
