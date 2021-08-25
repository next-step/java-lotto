package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호 유효값 검증")
    void create() {
        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = new BonusNumber(68);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}