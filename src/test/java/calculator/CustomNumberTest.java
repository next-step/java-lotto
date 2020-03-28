package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CustomNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-2, -9, -13})
    void of_inputNegative_throwRuntimeException(int input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            CustomNumber.of(input);
        }).withMessage(String.format("숫자에 음수 값(%d)이 들어올 수 없습니다.", input));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 0})
    void of_inputNaturalNumberInclude0_returnObject(int input) {
        CustomNumber number = CustomNumber.of(input);
        assertThat(number).isEqualTo(CustomNumber.of(input));
    }
}
