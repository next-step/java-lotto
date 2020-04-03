package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("로또당첨번호 생성 테스트")
    void createWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);
    }

    @Test
    @DisplayName("보너스번호 중복으로인한 실패 테스트")
    void validateBonusNumberTest() {
        assertThatThrownBy(
                () -> new WinningLotto("1,2,3,4,5,6", 3)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
