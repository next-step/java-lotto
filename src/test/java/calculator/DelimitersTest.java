package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DelimitersTest {

    @ParameterizedTest
    @ValueSource(chars = {'[', ']', '|', '<', '>', 'A', '8'})
    void validateExistDelimiter_test(char delimiter) {
        //when
        assertThatIllegalArgumentException().isThrownBy(() -> Delimiters.validateExistDelimiter(delimiter));
    }
}
