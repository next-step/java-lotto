package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("금액을 정상적으로 생성한다.")
    void createSuccess() {
        /* given */
        final long value = 1_000L;

        /* when & then */
        assertDoesNotThrow(() -> Money.valueOf(value));
    }

    @Test
    @DisplayName("금액이 음수이면 IllegalArgumentException을 던진다.")
    void createFailure() {
        /* given */
        final long value = -1_000L;

        /* when & then */
        assertThrows(IllegalArgumentException.class, () -> Money.valueOf(value));
    }

    @Test
    @DisplayName("금액이 0인 객체를 생성한다.")
    void createZero() {
        /* given */

        /* when & then */
        assertThat(Money.createZero()).isSameAs(Money.valueOf(0L));
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void calculateRateOfReturn() {
        /* given */
        final Money earned = Money.valueOf(10_000L);
        final Money spent = Money.valueOf(20_000L);

        /* when */
        final RateOfReturn rateOfReturn = Money.calculateRateOfReturn(earned, spent);

        /* then */
        assertThat(rateOfReturn).isEqualTo(new RateOfReturn((double) 10_000L / 20_000L));
    }

    @Test
    @DisplayName("금액의 배수 여부를 반환한다.")
    void isMultipleOf() {
        /* given */
        final Money threeThousands = Money.valueOf(3_000L);
        final Money twoThousands = Money.valueOf(2_000L);
        final Money oneThousand = Money.valueOf(1_000L);

        /* when & then */
        assertThat(threeThousands.isMultipleOf(oneThousand)).isTrue();
        assertThat(threeThousands.isMultipleOf(twoThousands)).isFalse();
    }

    @Test
    @DisplayName("최대 구매 개수를 반환한다.")
    void calculateMaximumCount() {
        /* given */
        final Money threeThousands = Money.valueOf(3_000L);
        final Money oneThousand = Money.valueOf(1_000L);

        /* when & then */
        assertThat(threeThousands.calculateMaximumCount(oneThousand)).isEqualTo(
            new Count(3));
    }

    @Test
    @DisplayName("가격의 합을 반환한다.")
    void sum() {
        /* given */
        final Money threeThousands = Money.valueOf(3_000L);
        final Money twoThousands = Money.valueOf(2_000L);
        final Money oneThousand = Money.valueOf(1_000L);

        /* when */
        final Money result = twoThousands.sum(oneThousand);

        /* then */
        assertThat(result).isEqualTo(threeThousands);
    }

    @Test
    @DisplayName("가격을 개수만큼 곱해서 반환한다.")
    void multiplyByCount() {
        /* given */
        final Money threeThousands = Money.valueOf(3_000L);
        final Money oneThousand = Money.valueOf(1_000L);
        final Count three = new Count(3);

        /* when */
        final Money result = oneThousand.multiplyByCount(three);

        /* then */
        assertThat(result).isEqualTo(threeThousands);
    }

    @Test
    @DisplayName("금액이 더 작은지 반환한다.")
    void isLessThan() {
        /* given */
        final Money oneThousand = Money.valueOf(1_000L);
        final Money threeThousands = Money.valueOf(3_000L);

        /* when & then */
        assertThat(oneThousand.isLessThan(threeThousands));
    }
}
