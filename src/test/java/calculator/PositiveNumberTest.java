package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
class PositiveNumberTest {

    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        PositiveNumber p = new PositiveNumber("0");
        assertThat(p.add(new PositiveNumber("1")).getNumber()).isEqualTo(1);
    }
}