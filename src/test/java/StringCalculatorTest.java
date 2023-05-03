import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class StringCalculatorTest {

    @Test
    void calculate() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");
        Assertions.assertThat(result).isEqualTo(10);
    }
}