package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionSplitterTest {

    @DisplayName("콜론을 구분자가 포함된 표현식 파싱")
    @ParameterizedTest
    @MethodSource("provideParseWithColonResource")
    void parseWithColon(String expression, int expectSize) {

        String[] elements = new ExpressionSplitter(expression).split();

        assertThat(elements.length).isEqualTo(expectSize);
    }

    private static Stream<Arguments> provideParseWithColonResource() {
        return Stream.of(
                Arguments.of("1:2", 2),
                Arguments.of("1:2:3", 3)
        );
    }

    @DisplayName("콜론으로 시작하거나 종료하는 표현식")
    @ParameterizedTest
    @MethodSource("provideParseWithColonStartOrEnd")
    void parseWithColonStartOrEnd(String expression, int expectSize) {

        String[] elements = new ExpressionSplitter(expression).split();

        assertThat(elements.length).isEqualTo(expectSize);

    }

    private static Stream<Arguments> provideParseWithColonStartOrEnd() {
        return Stream.of(
                Arguments.of(":2", 2),  // 구분자 맨 앞에오는 경우 빈문자열이 배열 맨앞에 포함된다.
                Arguments.of("1:2:", 2) // 구분자가 맨 뒤에오는 경우 맨뒤에 빈문자열이 없다.
        );
    }

    @DisplayName("빈값 입력 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t"})
    void parseEmptyValues(String expression) {
        String[] elements = new ExpressionSplitter(expression).split();

        assertThat(elements.length).isEqualTo(1);   // null 또는 공백문자는 빈문자열 1개를 포함하는 배열로 반환
    }

    @DisplayName("콤마 구분자가 포함된 표현식")
    @Test
    void parseWithComma(){

        String[] elements = new ExpressionSplitter("1,2").split();

        assertThat(elements.length).isEqualTo(2);
    }

    @DisplayName("콤마와 콜론이 함께 포함된 표현식")
    @Test
    void parseWithCommaAndColon(){
        String[] elements = new ExpressionSplitter("1,2:3").split();

        assertThat(elements.length).isEqualTo(3);
    }

    @DisplayName("다양한 커스텀 구분자 테스트")
    @ParameterizedTest
    @MethodSource("provideExtractionSeparator")
    void extractionSeparator(String expression, int expectSize) {

        String[] elements = new ExpressionSplitter(expression).split();

        assertThat(elements.length).isEqualTo(expectSize);

    }

    private static Stream<Arguments> provideExtractionSeparator() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 3),
                Arguments.of("//.\n1.2.3", 3),
                Arguments.of("//+\n1+2", 2),
                Arguments.of("//*\n1*", 1),
                Arguments.of("//-\n-1", 2)
        );
    }
}
