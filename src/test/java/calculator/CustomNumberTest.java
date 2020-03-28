package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CustomNumberTest {

    @Test
    void of_inputNegative_throwRuntimeException() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
           CustomNumber.of(-1);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 0})
    void of_inputNaturalNumberInclude0_returnObject(int input) {
        CustomNumber number = CustomNumber.of(input);
        assertThat(number).isEqualTo(CustomNumber.of(input));
    }
}
