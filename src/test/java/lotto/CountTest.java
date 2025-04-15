package lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Count;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    @DisplayName("count는 0이상의 숫자여야 한다.")
    void countIsPositive() {
        assertThatThrownBy(() -> new Count(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("equals")
    void equals() {
        Count count = new Count(10);
        Count other = new Count(10);
        assertThat(count.equals(other)).isTrue();
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        Count count = new Count(10);
        Count other = new Count(5);
        assertThat(count.subtract(other))
            .isEqualTo(new Count(5));
    }

    @Test
    @DisplayName("isLessThan")
    void isLessThan() {
        Count count = new Count(10);
        Count other = new Count(5);
        assertThat(count.isLessThan(other)).isFalse();
        assertThat(other.isLessThan(count)).isTrue();
    }
}
