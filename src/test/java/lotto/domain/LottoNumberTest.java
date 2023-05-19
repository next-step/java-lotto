package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberValidationUtilsTest {

    @Test
    @DisplayName("[요구사항 1] 로또 번호가 1 ~ 45 사이의 숫자가 아닐 경우, IllegalArgumentException을 던진다.")
    void 요구사항_1() {
        // given
        int givenNumber = 46;

        // then
        assertThatThrownBy(() -> new LottoNumber(givenNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1과 45 사이의 숫자여야만 합니다.");
    }
}
