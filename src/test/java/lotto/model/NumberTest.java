package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 7, 43, 23})
    @DisplayName("create number test : success")
    void createNumberTest(int input) {
        assertThat(new Number(input).value()).isEqualTo(input);
    }

    @ParameterizedTest
    @DisplayName("create Number by String value Test : success")
    @ValueSource(strings = {"4", "6", "7", "43", "23"})
    void createNumberByStringTest(String input) {
        assertThat(new Number(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 90, 100})
    @DisplayName("create Number by Illegal param Test : fail")
    void illegaleNumberTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

}
