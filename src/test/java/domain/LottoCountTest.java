package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

    @Test
    @DisplayName("개수를 정상적으로 생성한다.")
    void createSuccess() {
        /* given */
        final long value = 2L;

        /* when & then*/
        Assertions.assertDoesNotThrow(() -> new LottoCount(value));
    }

    @Test
    @DisplayName("개수로 음수를 입력하면 IllegalArgumentException을 던진다.")
    void createFailure() {
        /* given */
        final long value = -1L;

        /* when & then */
        assertThrows(IllegalArgumentException.class, () -> new LottoCount(value));
    }

    @Test
    @DisplayName("개수가 0인지 boolean으로 반환한다.")
    void isZero() {
        /* given */
        final LottoCount one = new LottoCount(1);
        final LottoCount zero = new LottoCount(0);

        /* when & then */
        assertThat(zero.isZero()).isTrue();
        assertThat(one.isZero()).isFalse();
    }

    @Test
    @DisplayName("개수가 더 적은지 boolean으로 반환한다.")
    void isLessThan() {
        /* given */
        final LottoCount three = new LottoCount(3);
        final LottoCount five = new LottoCount(5);

        /* when & then */
        assertThat(three.isLessThan(five)).isTrue();
        assertThat(five.isLessThan(three)).isFalse();
    }

    @Test
    @DisplayName("개수 간의 차이를 반환한다.")
    void decreaseBy() {
        /* given */
        final LottoCount five = new LottoCount(5);
        final LottoCount three = new LottoCount(3);
        final LottoCount two = new LottoCount(2);

        /* when & then */
        assertThat(five.decreaseBy(three)).isEqualTo(two);
    }
}
