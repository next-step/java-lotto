package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchCount {
    public static final String INVALID_COUNT_EXCEPTION_MESSAGE = "당첨 번호는 0 이상 6 이하만 가능합니다.";
    public static final int MIN = 0;
    public static final int MAX = 6;
    private final int count;

    private static final Map<Integer, MatchCount> CACHE;

    static {
        Map<Integer, MatchCount> map = new HashMap<>();
        for (int i = MIN; i <= MAX; i++) {
            map.put(i, new MatchCount(i));
        }
        CACHE = Collections.unmodifiableMap(map);
    }

    private MatchCount(int count) {
        this.count = count;
    }

    public static MatchCount of(int count) {
        if (count < MIN || count > MAX) {
            throw new IllegalArgumentException(INVALID_COUNT_EXCEPTION_MESSAGE);
        }
        return CACHE.get(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MatchCount)) return false;
        MatchCount other = (MatchCount) obj;
        return count == other.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
