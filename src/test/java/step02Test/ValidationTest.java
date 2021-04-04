package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.Validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    @DisplayName("최대 숫자 범위 초과 테스트")
    void overMaxNumber() {
        assertThatThrownBy(() ->
                Validation.overMaxNumber(50))
                .isInstanceOf(Exception.class).hasMessage("로또 숫자는 45이하의 수를 입력해주세요.");

    }
}
