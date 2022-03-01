package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberExtractorTest {

    @DisplayName("구분자를_기준으로_숫자를_나눈다")
    @ParameterizedTest
    @MethodSource(value = "sourceOfDelimiterTest")
    void delimiterTest(String text, List<Integer> numbers) {
        final List<String> delimiters = Arrays.asList(",", ":", "-");
        assertThat(NumberExtractor.splitNumbersByDelimiter(text, delimiters)).isEqualTo(numbers);
    }

    private static Stream<Arguments> sourceOfDelimiterTest() {
        return Stream.of(
            Arguments.of("1,2:3", Arrays.asList(1, 2, 3)),
            Arguments.of("123-342:330209", Arrays.asList(123, 342, 330209)),
            Arguments.of("0,1:2-3,4:5:6:7-8,9", Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:3:3:", "1::3", ":1:32:2", "1ab:3", "1:2:", "1:2a3a"})
    void 숫자_이외의_값이_들어가는_경우(String text) {
        final List<String> delimiters = Arrays.asList(",", ":", "a");
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> NumberExtractor.splitNumbersByDelimiter(text, delimiters))
            .withMessage("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,3a-2", "22,-23a3123:1"})
    void 음수가_들어가는_경우(String text) {
        final List<String> delimiters = Arrays.asList(",", ":", "a");
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> NumberExtractor.splitNumbersByDelimiter(text, delimiters))
            .withMessage("[ERROR] 음수 값은 입력할 수 없습니다.");
    }
}
