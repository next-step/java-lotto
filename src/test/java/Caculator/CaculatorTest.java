package Caculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CaculatorTest {

    private Caculator caculator;

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환 해야 함")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyInputText(String input) {
        caculator = new Caculator(input);
        int result = caculator.validateInputText();

        assertThat(result).isEqualTo(0);
    }

}
