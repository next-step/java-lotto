package lotto.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UnsignedIntegerTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    void testParseSuccess(String string) {
        assertThatNoException().isThrownBy(() -> UnsignedInteger.parse(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "A"})
    void testParseFail(String string) {
        assertThatThrownBy(() -> UnsignedInteger.parse(string))
                .isInstanceOf(NumberFormatException.class);
    }
}
