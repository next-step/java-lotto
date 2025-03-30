package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class GameResult {
    private final Map<Rank, Integer> resultStats;
    private final double returnRate;

    public GameResult(Map<Rank, Integer> resultStats, double returnRate) {
        this.resultStats = Collections.unmodifiableMap(new EnumMap<>(resultStats));
        this.returnRate = returnRate;
    }

    public Map<Rank, Integer> getResultStats() {
        return resultStats;
    }

    public double getReturnRate() {
        return returnRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 같은 주소값일 경우 true
        if (o == null || getClass() != o.getClass()) return false; // 클래스 타입이 다르면 false
        GameResult that = (GameResult) o;
        // 필드 값 비교: resultStats와 returnRate
        return Double.compare(that.returnRate, returnRate) == 0 &&
                Objects.equals(resultStats, that.resultStats);
    }

}
