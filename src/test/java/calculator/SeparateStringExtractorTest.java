package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparateStringExtractorTest {

    @DisplayName("다양한 커스텀 구분자 테스트")
    @ParameterizedTest
    @MethodSource("provideExtractionSeparator")
    void extractionSeparator(String expression, String expectSeparator) {

        String separator = SeparateStringExtractor.execute(expression);

        assertThat(separator).isEqualTo(expectSeparator);
    }

    private static Stream<Arguments> provideExtractionSeparator() {
        return Stream.of(
                Arguments.of("//;\n", ";"),
                Arguments.of("//+\n", "+"),
                Arguments.of("//*\n", "*"),
                Arguments.of("//-\n", "-")
        );
    }
}
