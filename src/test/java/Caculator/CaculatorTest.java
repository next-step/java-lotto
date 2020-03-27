package Caculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CaculatorTest {

    private Caculator caculator;

    @BeforeEach
    void setUp() {
        caculator = new Caculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환 해야 함")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyInputText(String input) {
        int result = caculator.validateInputText(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = { "1:1", "2:2", "5:5", "10:10" }, delimiter = ':')
    void oneNumberInputText(String input, int output) {
        int result = caculator.oneNumberInputText(input);
        assertThat(result).isEqualTo(output);
    }
}
