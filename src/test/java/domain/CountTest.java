package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    @DisplayName("개수를 정상적으로 생성한다.")
    void createSuccess() {
        /* given */
        final long value = 2L;

        /* when & then*/
        Assertions.assertDoesNotThrow(() -> new Count(value));
    }

    @Test
    @DisplayName("개수로 음수를 입력하면 IllegalArgumentException을 던진다.")
    void createFailure() {
        /* given */
        final long value = -1L;

        /* when & then */
        assertThrows(IllegalArgumentException.class, () -> new Count(value));
    }

    @Test
    @DisplayName("개수가 양수인지 boolean으로 반환한다.")
    void isPositive() {
        /* given */
        final Count notZeroCount = new Count(1);
        final Count zeroCount = new Count(0);

        /* when & then */
        assertThat(notZeroCount.isPositive()).isTrue();
        assertThat(zeroCount.isPositive()).isFalse();
    }

    @Test
    @DisplayName("개수가 더 적은지 boolean으로 반환한다.")
    void isLessThan() {
        /* given */
        final Count three = new Count(3);
        final Count five = new Count(5);

        /* when & then */
        assertThat(three.isLessThan(five)).isTrue();
        assertThat(five.isLessThan(three)).isFalse();
    }

    @Test
    @DisplayName("개수가 같지 않은지 boolean으로 반환한다.")
    void isNotEqualTo() {
        /* given */
        final Count three = new Count(3);
        final Count five = new Count(5);

        /* when & then */
        assertThat(three.isNotEqualTo(five)).isTrue();
    }

    @Test
    @DisplayName("개수 간의 차이를 반환한다.")
    void decreaseBy() {
        /* given */
        final Count five = new Count(5);
        final Count three = new Count(3);
        final Count two = new Count(2);

        /* when & then */
        assertThat(five.decreaseBy(three)).isEqualTo(two);
    }

    @Test
    @DisplayName("개수를 하나 빼서 반환한다.")
    void decreaseByOne() {
        /* given */
        final Count three = new Count(3);
        final Count two = new Count(2);

        /* when & then */
        assertThat(three.decreaseByOne()).isEqualTo(two);
    }
}
