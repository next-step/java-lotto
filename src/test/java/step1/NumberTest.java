package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Number;
import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void numberTest() {
        Number number1 = new Number(1);
        Number number2 = new Number(1);
        assertThat(number1).isEqualTo(number2);
    }

    @Test
    void checkBiggerThanZeroCheck() {
        assertThatThrownBy(() -> {
            Number number = new Number(-10);
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("0보다 작은 값이 존재합니다.");
    }
}
