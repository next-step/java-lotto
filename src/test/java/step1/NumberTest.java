package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.Number;

public class NumberTest {
    @Test
    @DisplayName("값이 없을 경우 IllegalArgumentException 발생")
    public void nullValue() {
        String nullValue = null;
        assertThatThrownBy(
            () -> Number.of(nullValue)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 값의 경우 IllegalArgumentException 발생")
    public void emptyValue() {
        assertThatThrownBy(
            () -> Number.of("")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
