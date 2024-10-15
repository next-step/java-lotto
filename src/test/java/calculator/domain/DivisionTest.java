package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionTest {

    @Test
    void 나눗셈() {

        Division division = new Division();

        assertThat(division.calculate(6, 2)).isEqualTo(3);
    }
}