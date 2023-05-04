package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자가 아닌값이 들어왔을 때")
    @ParameterizedTest
    @ValueSource(strings = {"+","*","%","/"})
    void 숫자_입력_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(input))
                .withMessageMatching("숫자가 아닙니다.");
    }

}
