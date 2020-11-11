package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.LotteryAgentTest.LotteryAgent.PRICE_LOTTERY;

public class LotteryResultTest {
    @DisplayName("6개를 초과하는 입력은 예외를 발생한다.")
    @Test
    void moreThen_7() {
        assertThatThrownBy(() -> new LotteryResult().add(7)) //
                .isInstanceOf(OutOfMatchingBoundaryException.class);
    }

    @DisplayName("0개를 미만 입력은 예외를 발생한다.")
    @Test
    void lessThen_0() {
        assertThatThrownBy(() -> new LotteryResult().add(-1)) //
                .isInstanceOf(OutOfMatchingBoundaryException.class);
    }

    @DisplayName("3개 맞췄을 때 수익률을 계산한다.")
    @Test
    void rateOfReturn() {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.add(3);
        for (int i = 0; i < 13; i++) {
            lotteryResult.add(i % 3);
        }
        assertThat(lotteryResult.getRateOfReturn()) //
                .isEqualTo(0.35714287f);
    }

    enum Rank {
        FIRST(6, Money.of(2_000_000_000)), //
        SECOND(5, Money.of(1_500_000)), //
        THIRD(4, Money.of(50_000)),  //
        FORTH(3, Money.of(5_000)),  //
        MISS(0, Money.of(0));

        private final int matchingCount;
        private final Money prizeAmount;

        Rank(int matchingCount, Money prizeAmount) {
            this.matchingCount = matchingCount;
            this.prizeAmount = prizeAmount;
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

            result.compute(Rank.valueFrom(matchCount), this::addOrDefault);
        }

        private Integer addOrDefault(Rank rank, Integer value) {
            if (value == null) {
                return 1;
            }
            return value + 1;
        }

        public int getMatchResult(Rank rank) {
            return result.getOrDefault(rank, 0);
        }

        public float getRateOfReturn() {
            Money totalAmount = result.values() //
                    .stream() //
                    .map(PRICE_LOTTERY::multiply) //
                    .reduce(Money::add) //
                    .orElse(Money.of(0));

            Money returnAmount = result.entrySet() //
                    .stream() //
                    .map(entry -> { //
                        Rank rank = entry.getKey();
                        Integer count = entry.getValue();
                        return rank.prizeAmount.multiply(count);
                    }).reduce(Money::add) //
                    .orElse(Money.of(0));

            return (float) returnAmount.toInt() / totalAmount.toInt();
        }
    }

    private static class OutOfMatchingBoundaryException extends RuntimeException {
    }
}
