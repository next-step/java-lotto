package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringSeparatorTest {

    private final StringSeparator stringSeparator = new StringSeparator();

    @ParameterizedTest(name = "NULL 또는 공백 인 경우")
    @NullAndEmptySource
    void isNullOrEmptyTest_빈_공백_NULL(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringSeparator.separateByDelimiter(input))
                .withMessage("NULL 또는 공백은 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "0으로 나누는 경우")
    @ValueSource(strings = {"1 / 0", "1 * 2 / 0"})
    void isDividedZeroTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringSeparator.separateByDelimiter(input))
                .withMessage("0으로 나눌 수 없습니다.");
    }
}
