package lotto.domain;

import lotto.domain.SeparateNumber;
import lotto.exception.IllegalSeparateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SeparateNumberTest {

    @DisplayName("입력 받는 번호는 \",\" 구분자로 입력받는다.")
    @Test
    void separate_validation() {
        assertThatThrownBy(() -> SeparateNumber.of("1:2:3:4:5:6"))
                .isInstanceOf(IllegalSeparateException.class);
    }
}