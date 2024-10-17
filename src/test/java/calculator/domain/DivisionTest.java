package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DivisionTest {

    @Test
    void 나눗셈() {

        Division division = new Division();

        assertThat(division.calculate(6, 2)).isEqualTo(3);
    }

    @Test
    void 두번째_값은_0을_혀용하지_않는다() {

        assertThatThrownBy(() ->
                new Division().calculate(5, 0)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 결과값은_정수만_허용한다() {

        assertThatThrownBy(() ->
                new Division().calculate(5, 2)
        ).isInstanceOf(IllegalArgumentException.class);

    }

}