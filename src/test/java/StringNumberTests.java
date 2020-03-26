import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringAddCalculator.model.Numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringNumberTests {

    @DisplayName("Numbers 생성 테스트")
    @ParameterizedTest
    @MethodSource("createNumbersNormalCases")
    public void createNumbersTest(List<String> numbers) {
        assertThatCode(() -> Numbers.create(numbers.toArray(new String[0]))).doesNotThrowAnyException();
    }

    @DisplayName("Numbers 생성 - 마이너스 숫자 테스트")
    @Test
    public void createMinusNumbersTest() {
        String[] input = new String[]{"0", "-1"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Numbers.create(input))
                .withMessageMatching("number must be greater than zero.");
    }

    @DisplayName("Numbers 생성 - 숫자 아닌 문자열 인풋 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "a"})
    public void createMinusNumbersTest(String input) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> Numbers.create(new String[]{input}));
    }

    @DisplayName("Numbers 합계 테스트")
    @ParameterizedTest
    @MethodSource("sumNumbersNormalCases")
    public void sumNumbersTest(Numbers numbers, int expectedResult) {
        assertThat(numbers.sum()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> createNumbersNormalCases() {
        return Stream.of(
                Arguments.of(Collections.singletonList("1")),
                Arguments.of(Collections.emptyList()),
                Arguments.of(Arrays.asList("1", "2", "3"))
        );
    }

    private static Stream<Arguments> sumNumbersNormalCases() {
        return Stream.of(
                Arguments.of(Numbers.create(new String[]{"1", "2", "3"}), 6),
                Arguments.of(Numbers.create(new String[]{"10", "21", "9"}), 40)
        );
    }
}
