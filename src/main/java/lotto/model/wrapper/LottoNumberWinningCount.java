package lotto.model.wrapper;

import lotto.model.BonusNumberMatchingStatus;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberWinningCount {
    private static final int WINNING_LOTTO_MIN_MATCH_COUNT = 0;
    private static final int WINNING_LOTTO_MAX_MATCH_COUNT = 6;
    private static final int BONUS_NUMBER_CHECK_MATCH_COUNT = 5;
    private static final Map<Integer, LottoNumberWinningCount> COUNTS;

    private final int count;

    static {
        COUNTS = Collections.unmodifiableMap(IntStream.rangeClosed(WINNING_LOTTO_MIN_MATCH_COUNT, WINNING_LOTTO_MAX_MATCH_COUNT)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumberWinningCount::new)));
    }

    private LottoNumberWinningCount(final int count) {
        this.count = count;
    }

    public static LottoNumberWinningCount of(final int count) {
        LottoNumberWinningCount lottoNumberWinningCount = COUNTS.get(count);

        if (lottoNumberWinningCount == null) {
            throw new IllegalArgumentException("당첨 번호와 매칭되는 숫자는 0 이상, 6 이하여야 합니다.");
        }

        return lottoNumberWinningCount;
    }

    public BonusNumberMatchingStatus getLottoBonusNumberMatchStatus(final boolean isMatchedBonusNumber) {
        if (count == BONUS_NUMBER_CHECK_MATCH_COUNT) {
            return BonusNumberMatchingStatus.createByMatchBonusNumber(isMatchedBonusNumber);
        }
        return BonusNumberMatchingStatus.ANYWAY;
    }

    public int toInt() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumberWinningCount)) return false;
        LottoNumberWinningCount that = (LottoNumberWinningCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
