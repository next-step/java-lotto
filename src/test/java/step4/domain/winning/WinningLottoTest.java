package step4.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("WinningLotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String StringWinningLotto = "1, 2, 3, 4, 5, 6";
        int bonusLottoNumber = 7;

        // when
        WinningLotto winningLotto = WinningLotto.from(StringWinningLotto, bonusLottoNumber);

        // then
        assertThat(winningLotto).isNotNull();
    }
}