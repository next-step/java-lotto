package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class PositiveNumberTest {

    @Test
    @DisplayName("문자를 통한 생성")
    void create() {
        PositiveNumber p = new PositiveNumber("0");
        assertThat(p.getNumber()).isEqualTo(0);
    }

    @Test
    @DisplayName("덧셈")
    void add() {
        PositiveNumber p = new PositiveNumber(0);
        assertThat(p.add(new PositiveNumber(1)).getNumber()).isEqualTo(1);
    }
}