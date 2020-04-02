package lotto.model.wrapper;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMatchCount {

    private static final int LOTTO_MIN_MATCH_COUNT = 0;
    private static final int LOTTO_MAX_MATCH_COUNT = 6;
    private static final int BONUS_MUST_CHECK_MATCH_COUNT = 5;
    private static final Map<Integer, LottoMatchCount> COUNTS;

    public static LottoMatchCount BONUS_CHECK_COUNT;

    private final int count;

    static {
        COUNTS = Collections.unmodifiableMap(IntStream.rangeClosed(LOTTO_MIN_MATCH_COUNT, LOTTO_MAX_MATCH_COUNT)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoMatchCount::new)));
        BONUS_CHECK_COUNT = LottoMatchCount.of(BONUS_MUST_CHECK_MATCH_COUNT);
    }

    private LottoMatchCount(final int count) {
        this.count = count;
    }

    public static LottoMatchCount of(final int count) {
        return Optional.ofNullable(COUNTS.get(count))
                .orElseThrow(() -> new IllegalArgumentException("Match Count must be between 0 and 6."));
    }

    public int toInt() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoMatchCount)) return false;
        LottoMatchCount that = (LottoMatchCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
