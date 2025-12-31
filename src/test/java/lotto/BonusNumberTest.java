package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호는 1~45 범위를 벗어나면 예외가 발생한다")
    void bonusNumberMustBeInRange() {
        assertThatThrownBy(() -> BonusNumber.of(0))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumber.of(46))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
