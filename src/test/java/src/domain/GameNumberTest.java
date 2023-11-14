package src.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import src.domain.GameNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void 게임_번호는_1에서_45_범위에서_생성_가능하다(int number) {
        // when then
        assertThatThrownBy(() -> GameNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
    }
}
