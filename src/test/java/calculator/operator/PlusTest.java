package calculator.operator;

import calculator.domain.operator.Plus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusTest {

    @Test
    @DisplayName("기본 더하기 테스트")
    void plus() {
        assertThat(new Plus(3).execute(6)).isEqualTo(9);
    }
}
