package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperationTest {

    @DisplayName("사칙연산이 아닐 경우 Exception을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "d", "//"})
    public void signTest(String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> Operation.toOperation(input)
        );
    }

}
