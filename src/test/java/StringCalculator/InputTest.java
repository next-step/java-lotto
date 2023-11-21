package StringCalculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("정상적이지 않은 입력에 대해서 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "102", "-102", "1+ 2", "a + 2"})
    void validateInput(String input) {
        systemIn(input);

        assertThatIllegalArgumentException().isThrownBy(InputView::inputCalculation);
    }
}
