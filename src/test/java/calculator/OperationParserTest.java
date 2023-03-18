package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperationParserTest {

    @DisplayName("입력 문자열 유효성 검사 실패")
    @ParameterizedTest
    @ValueSource(strings = {"    ", ""})
    void invalidTextTest(String text) {
        assertThrows(RuntimeException.class, () ->{
            OperationParser.parseDelimiter(text);
        });
    }

    void nullTextTest() {
        String text = null;
        assertThrows(RuntimeException.class, () ->{
            OperationParser.parseDelimiter(text);
        });
    }

    @DisplayName("기본 구분자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3"})
    void defaultParseDelimiterTest(String text) {
        String actual = OperationParser.parseDelimiter(text);
        assertThat(actual).isEqualTo(",|:");
    }

    @DisplayName("커스텀 구분자를 반환")
    @Test
    void customParseDelimiterTest() {
        String text = "//;\n1;2;3";
        String actual = OperationParser.parseDelimiter(text);
        assertThat(actual).isEqualTo(";");
    }

    @DisplayName("기본 구분자인 경우, 입력값과 동일 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1:3:4", "1,3:4"})
    void defaultDelimiterRemoveTest(String text) {
        String actual = OperationParser.getDefaultOperation(text, ",|:");
        assertTrue(actual.equals(text));
    }

    @DisplayName("커스텀 구분자인 경우, 앞의 커스텀 구분자 지정문자 제거 반환확인")
    @Test
    void removeCustomDelimiter() {
        String text = "//;\n1;2;3";
        String actual = OperationParser.getDefaultOperation(text, ";");
        assertTrue(actual.equals("1;2;3"));
    }
}