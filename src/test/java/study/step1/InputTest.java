package study.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.step1.domain.dto.Input;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputTest {

    @ParameterizedTest
    @NullAndEmptySource
    void null_공백_입력(String string) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Input(string))
            .withMessage("InputError: 입력값 오류(빈 값 혹은 공백)");
    }
}
