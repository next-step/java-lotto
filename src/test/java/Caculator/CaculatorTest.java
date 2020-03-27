package Caculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
        int result = caculator.splitNumberAndCharater(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("숫자 두개를 컴마 구분자로 입력 할 경우 두 숫자의 합을 반환한다")
    @Test
    void splitNumberAndSumByComma() {
        int result = caculator.splitNumberAndCharater("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("숫자 두개를 컴마 구분자로 입력 할 경우 두 숫자의 합을 반환한다")
    @Test
    void splitNumberAndSumByCharater() {
        int result = caculator.splitNumberAndCharater("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void splitNumberAndCustomSeparator() {
        int result = caculator.splitNumberAndCustomSeparator("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수를 전달 할경우 RuntimeException 예외가 발생해야된다")
    @Test
    void inputTextIsNegative() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            caculator.inputTextIsNegative("-1,2,3");
        });

        assertThat(runtimeException.getMessage()).isEqualTo("음수가 들어 올 수 없습니다.");

    }
}
