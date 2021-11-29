package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        assertThat(WinningLotto.of("1,2,3,4,5,6", "8"))
                .isEqualTo(WinningLotto.of("1,2,3,4,5,6", "8"));

    }

    @DisplayName("로또안에 보너스볼이 있으면 익센션 발생한다.")
    @Test
    void createFailTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of("1,2,3,4,5,6", "6"));
    }

}
