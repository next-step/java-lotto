package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("지난 주 당첨 번호 및 보너스 볼을 저장하는 Winning Lotto 정상 생성 테스트")
    void winningLotto_create() {
        Lotto lotto = new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6"));
        Ball bonusBall = new Ball("7");

        assertDoesNotThrow(() -> new WinningLotto(lotto, bonusBall));
    }

    @Test
    @DisplayName("지난 주 당첨 번호와 보너스 볼 중복 검사 테스트")
    void winningLotto_validate() {
        Lotto lotto = new Lotto(LottoTest.getBalls("1", "2", "3", "4", "5", "6"));
        Ball bonusBall = new Ball("6");

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
