package calculator.domain;

import calculator.exception.NumberConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextSplitterTest {
    private final static List<Number> EXPECTED_NUMBERS = new ArrayList<>(Arrays.asList(new Number("1"), new Number("2"), new Number("3")));

    @DisplayName("textToNumbers 함수는 커스텀 구분자가 없으면 기본 구분자 기준으로 문자열을 List<Number>로 변환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2,3", "1:2:3", "1,2,3"})
    void sumWithDefaultDelimiter(String text) {
        assertThat(new TextSplitter(text).textToNumbers()).isEqualTo(EXPECTED_NUMBERS);
    }

    @DisplayName("textToNumbers 함수는 입력받은 커스텀 구분자를 기준으로 문자열을 List<Number>로 변환한다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//@\n1@2@3", "//#\n1#2#3"})
    void splitWithCustomDelimiter(String text) {
        assertThat(new TextSplitter(text).textToNumbers()).isEqualTo(EXPECTED_NUMBERS);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 NumberConstraintViolationException 예외를 throw한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,-2,3", "1,2,@", "text"})
    void exception(String text) {
        assertThatThrownBy(() -> new TextSplitter(text).textToNumbers()).isInstanceOf(NumberConstraintViolationException.class);
    }
}
