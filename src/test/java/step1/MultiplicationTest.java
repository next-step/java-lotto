package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {

    @ParameterizedTest(name = "x : {0} , y : {1}")
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    void 곱셈(int x, int y) {
        Multiplication multiplication = new Multiplication();
        assertThat(multiplication.apply(x, y)).isEqualTo(x * y);
    }
}