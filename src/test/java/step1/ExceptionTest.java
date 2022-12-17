package step1;

import step1.exception.SplitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class ExceptionTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "   "})
    @DisplayName("공백, 빈문자열 예외 테스트")
    public void splitTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                SplitException.split(input));
    }
}
