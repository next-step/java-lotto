package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NationalNumberTest {
    @Test
    @DisplayName("자연수 입력 실패 테스트")
    void 자연수_유효성검사_실패_테스트() {
        assertThatThrownBy(() -> NationalNumber.validateStrNumber("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
