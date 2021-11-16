package calculator.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.exception.CustomFormaterException;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CustomSplitStrategyTest {

    private CustomSplitStrategy customSplitStrategy;

    @BeforeEach
    void setUp() {
        customSplitStrategy = new CustomSplitStrategy();
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of("//+\\\\n1+2+3", "+", new String[]{"1", "2", "3"}),
            Arguments.of("//'\\\\n2'1'4'5", "'", new String[]{"2", "1", "4", "5"}),
            Arguments.of("//*\\\\n1*2*3", "*", new String[]{"1", "2", "3"})
        );
    }

    @ParameterizedTest
    @CsvSource(value = "1,2,3=,", delimiter = '=')
    @DisplayName("올바르지 않은 커스텀 계산 식일 경우")
    void customException(String input, String delimiter) {
        assertThatExceptionOfType(CustomFormaterException.class)
            .isThrownBy(() -> customSplitStrategy.getSplitInput(input, delimiter));

    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("정상적으로 스플릿 되는지 확인")
    void splitSuccess(String input, String delimiter, String[] result) {
        assertThat(customSplitStrategy.getSplitInput(input, delimiter)).isEqualTo(result);
    }

}
