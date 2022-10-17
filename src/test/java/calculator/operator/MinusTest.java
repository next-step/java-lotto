package calculator.operator;

import calculator.domain.operator.Minus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinusTest {

    @Test
    @DisplayName("기본 빼기 테스트")
    void minus() {
        assertThat(new Minus(6).execute(10)).isEqualTo(4);
    }
}
