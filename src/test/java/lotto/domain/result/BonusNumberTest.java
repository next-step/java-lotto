package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스번호를 1 - 45 가 아닌 숫자로 초기화 시 익셉션을 던진다")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    void bonus(int bonus) {
        assertThatThrownBy(() -> new BonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스번호는 1이상 45이하여야합니다");
    }

}
