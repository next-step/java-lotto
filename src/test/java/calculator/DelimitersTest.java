package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DelimitersTest {

    @Test
    void validateExistDelimiter_test() {
        //given
        char delimiter = '[';

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> Delimiters.validateExistDelimiter(delimiter));
    }
}
