package calculator.string.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {
    private static Delimiter delimiter;

    @BeforeEach
    public void beforeEach() {
        delimiter = new Delimiter();
    }

    @DisplayName("hasNewDelimiterTrueTest: 새로운 구분자 찾아내는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"//v\n1v2", "//]\n4]2", "//=\n9=10"})
    void hasNewDelimiterTrueTest(String input) {
        assertThat(delimiter.hasNewDelimiter(input)).isTrue();
    }

    @DisplayName("hasNewDelimiterFalseTest: 새로운 구분자 없는 것 인지하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "3:4", "25134,12"})
    void hasNewDelimiterFalseTest(String input) {
        assertThat(delimiter.hasNewDelimiter(input)).isFalse();
    }

    @DisplayName("updateDelimiterTest: Delimiter 업데이트가 제대로 이루어지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"//v\n1v2", "//]\n4]2", "//=\n9=10", "1,2", "3:4", "25134,12"})
    void updateDelimiterTest(String input) {
        if (delimiter.hasNewDelimiter(input)) {
            delimiter.updateDelimiter();
            System.out.println(delimiter.getDelimiters());
            assertThat(3).isEqualTo(
                    delimiter.getDelimiters().split("\\|").length);
            return;
        }
        assertThat(2).isEqualTo(
                delimiter.getDelimiters().split("\\|").length);
    }


    @DisplayName("extractExpressionTest: 식에서 정규식을 제외하고 제대로 된 식이 추출되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"//v\n1v2", "//]\n4]2", "//=\n9=10"})
    void extractExpressionTest(String input) {
        if (delimiter.hasNewDelimiter(input)) {
            assertThat(delimiter.hasNewDelimiter(
                    delimiter.extractExpression())).isFalse();
        }
    }

    private static Stream<Arguments> provideExpressionCorrectDelimiter() {
        String[][] inputExpressionDelimiters = {{"//v\n1v2", ":|,|v"},
                {"//]\n4]2", ":|,|]"},
                {"//=\n9=10", ":|,|="},
                {"25134,12", ":|,"}};

        Stream<Arguments> expressionDelimiterTestArguments = Stream.empty();
        for (String[] argumentElement : inputExpressionDelimiters) {
            expressionDelimiterTestArguments = Stream.concat(expressionDelimiterTestArguments,
                    Stream.of(Arguments.of(Arrays.asList(argumentElement))));
        }
        return expressionDelimiterTestArguments;
    }

    @DisplayName("getDelimitersTest: Delimiter 들 사이에 | 로 합쳐진 Delimiter를 잘 만드는지 확인")
    @ParameterizedTest
    @MethodSource("provideExpressionCorrectDelimiter")
    void getDelimitersTest(List<String> expressionDelimiter) {
        if (delimiter.hasNewDelimiter(expressionDelimiter.get(0))) {
            delimiter.updateDelimiter();
        }
        assertThat(delimiter.getDelimiters()).isEqualTo(expressionDelimiter.get(1));
    }
}