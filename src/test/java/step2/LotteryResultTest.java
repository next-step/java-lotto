package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LotteryResultTest {
    @DisplayName("6개를 초과하는 입력은 예외를 발생한다.")
    @Test
    void moreThen_7() {
        Assertions.assertThatThrownBy(() -> new LotteryResult().add(7)) //
                .isInstanceOf(OutOfMatchingBoundaryException.class);
    }

    @DisplayName("0개를 미만 입력은 예외를 발생한다.")
    @Test
    void lessThen_0() {
        Assertions.assertThatThrownBy(() -> new LotteryResult().add(-1)) //
                .isInstanceOf(OutOfMatchingBoundaryException.class);
    }

    enum Rank {
        FIRST(6), //
        SECOND(5), //
        THIRD(4),  //
        FORTH(3),  //
        MISS(0);

        private final int matchingCount;

        Rank(int matchingCount) {
            this.matchingCount = matchingCount;
        }

        public static Rank valueFrom(int matchCount) {
            int availableMatchCount = getAvailableMatchCount(matchCount);
            return Arrays.stream(values()) //
                    .filter(value -> value.matchingCount == availableMatchCount) //
                    .findFirst() //
                    .orElseThrow(OutOfMatchingBoundaryException::new);
        }

        private static int getAvailableMatchCount(int matchCount) {
            if (matchCount < 3) {
                return 0;
            }
            return matchCount;
        }
    }

    static class LotteryResult {

        private final Map<Rank, Integer> result = new HashMap<>();

        public void add(int matchCount) {
            if (matchCount < 0) {
                throw new OutOfMatchingBoundaryException();
            }

            Rank rankEnum = Rank.valueFrom(matchCount);

            result.compute(rankEnum, (key, value) -> value == null ? 1 : value + 1);
        }

        public int getMatchResult(Rank rank) {
            return result.getOrDefault(rank, 0);
        }
    }

    private static class OutOfMatchingBoundaryException extends RuntimeException {
    }
}
