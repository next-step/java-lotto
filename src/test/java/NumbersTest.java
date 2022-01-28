import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,5,3", "1,5:3", "//;\n1;5;3", "//;\n1;5,3"})
    void 연산자를_구분자기준_분리(String expression) {
        // when
        Numbers numbers = new Numbers(expression);

        // then
        assertThat(numbers.get(0).getNumber()).isEqualTo(1);
        assertThat(numbers.get(1).getNumber()).isEqualTo(5);
        assertThat(numbers.get(2).getNumber()).isEqualTo(3);
    }
}
