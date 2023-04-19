package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringSeparatorTest {

    private final StringSeparator stringSeparator = new StringSeparator();

    @ParameterizedTest(name = "NULL 또는 공백 인 경우")
    @NullAndEmptySource
    void validateNullOrEmptyTest_빈_공백_NULL(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringSeparator.separateByDelimiter(input))
                .withMessage("NULL 또는 공백은 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "0으로 나누는 경우")
    @ValueSource(strings = {"1 / 0", "1 * 2 / 0"})
    void validateDividedZeroTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringSeparator.separateByDelimiter(input))
                .withMessage("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest(name = "문자열을 Iterator로 분리하는 경우")
    @MethodSource("provideInputString")
    void separateByDelimiterTest(String input, List<String> expected) {
        List<String> separatedInput = stringSeparator.separateByDelimiter(input);
        assertThat(separatedInput).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> provideInputString() {
        return Stream.of(
                arguments(("1 + 2 + 3"), List.of("1","+","2","+","3")),
                arguments(("1 - 2 - 3"), List.of("1","-","2","-","3")),
                arguments(("1 / 2 / 3"), List.of("1","/","2","/","3"))
        );
    }
}
