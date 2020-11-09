package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LotteryResultTest {
    @DisplayName("6개를 초과하는 입력은 예외를 발생한다.")
    @Test
    void upper7() {
        Assertions.assertThatThrownBy(() -> new LotteryResult().add(7)) //
                .isInstanceOf(OutOfMatchingBoundaryException.class);
    }

    static class LotteryResult {
        enum Matched {
            miss(0), three(3), four(4), five(5), six(6);

            private final int matchingCount;

            Matched(int matchingCount) {
                this.matchingCount = matchingCount;
            }

            public static Matched valueBy(Supplier<Integer> matched) {
                return Arrays.stream(values()) //
                        .filter(value -> value.matchingCount == matched.get()) //
                        .findFirst().orElseThrow(IllegalArgumentException::new);
            }
        }

        private final Map<Matched, Integer> result = new HashMap<>();

        public void add(int matched) {
            Matched matchedEnum = Matched.valueBy(() -> {
                if (matched < 3) {
                    return 0;
                } return matched;
            });

            result.compute(matchedEnum, (key, value) -> value == null ? 1 : value + 1);
        }

        public int getMatchResult(Matched matched) {
            return result.getOrDefault(matched, 0);
        }
    }
}
