package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"++", "--", "**", "//", "+-", "-*", "*/", "+-*/", "1", "a", "ㄱ"})
    void 사용불가연산(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator(input))
            .withMessageMatching("사용이 불가능한 연산자 입니다.");
    }

    @Test
    void 널() {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator(null))
            .withMessageMatching("연산자는 빈 값일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 스페이스(String input) {
        assertThatExceptionOfType(InvalidParameterException.class)
            .isThrownBy(() -> new Operator(input))
            .withMessageMatching("연산자는 빈 값일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 사용가능연산(String input) {
        assertThat(new Operator(input)).isEqualTo(new Operator(input));
    }

}
