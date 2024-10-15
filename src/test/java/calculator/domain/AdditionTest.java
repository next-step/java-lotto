package calculator.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AdditionTest {

    @Test
    void 더하기() {
        Addition addition = new Addition();

        Assertions.assertThat(addition.calculate(1, 1)).isEqualTo(2);
    }
}