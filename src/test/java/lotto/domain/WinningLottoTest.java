package lotto.domain;

import lotto.util.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoTest {

    @Test
    @DisplayName("보너스볼 중복 테스트")
    void bonus_ball_duplication_test() {
        assertThatThrownBy(() -> new WinningLotto(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,5,6")), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스볼 일치 확인 테스트")
    void bonus_ball_match_test() {
        WinningLotto winningLotto = new WinningLotto(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 45")), 7);
        assertEquals(Boolean.TRUE, winningLotto.isBonusBall(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 7")))));
        assertEquals(Boolean.FALSE, winningLotto.isBonusBall(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1, 2, 3, 4, 5, 8")))));
    }
}
