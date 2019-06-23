package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositiveNumberTest {
    @Test
    @DisplayName("양수가 입력되면 인스턴스가 생성된다")
    void constructor() {
        PositiveNumber positiveNumber = new PositiveNumber(1);
    }

    @Test
    @DisplayName("null 값으로 생성시 오류")
    void constructor() {
        PositiveNumber positiveNumber = new PositiveNumber(null);
    }

    @Test
    @DisplayName("음수값으로 생성시 오류")
    void constructor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PositiveNumber positiveNumber = new PositiveNumber(-1));
    }
}
