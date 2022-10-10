package step1;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domains.Operation;

public class OperationTest {
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void Given_Valid_String_When_ValueOf_Then_Success(String string) {
        assertThatNoException().isThrownBy(() -> Operation.parse(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"~", "!", "?", ":"})
    void Given_Invalid_String_When_ValueOf_Then_Fail(String string) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operation.parse(string));
    }
}
