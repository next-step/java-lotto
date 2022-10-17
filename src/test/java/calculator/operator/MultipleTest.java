package calculator.operator;

import calculator.domain.operator.Multiple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleTest {

    @Test
    @DisplayName("기본 곱하기 테스트")
    void multiple() {
        assertThat(new Multiple(3).execute(6)).isEqualTo(18);
    }
}
