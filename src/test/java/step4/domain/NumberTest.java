package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    @DisplayName("Check Number")
    @ParameterizedTest
    @ValueSource(strings = {"A", "z", "*"})
    void checkNumber(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Number.checkNumber(input)
        );
    }

    @DisplayName("Check Number")
    @ParameterizedTest
    @ValueSource(strings = {"A,1,3", "z,4,5", "*,7,8,3"})
    void checkNumberArray(String input) {
        String[] inputArray = input.split(",");
        assertThatIllegalArgumentException().isThrownBy(() ->
                Number.checkNumber(inputArray)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -199, -9999})
    void testCheckNumber(int input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Number.checkNotNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-199", "-9999"})
    @NullAndEmptySource
    void testCheckNumberString(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Number.checkNotNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,3,5", "1,2,3,-199", "-1,1,-9999"})
    void testCheckNumberStringArray(String input) {
        String[] inputArray = input.split(",");
        assertThatIllegalArgumentException().isThrownBy(() ->
                Number.checkNotNumber(inputArray));
    }

}
