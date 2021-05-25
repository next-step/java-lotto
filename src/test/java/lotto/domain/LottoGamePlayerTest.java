package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoGamePlayerTest {

    @Test
    @DisplayName("WinningType count 테스트")
    void getMatchCountResult() {
        WinningType[] winningTypes = {WinningType.FIRST, WinningType.SECOND, WinningType.SECOND, WinningType.SIXTH};
        Map<WinningType, Integer> matchCountResults = new LottoGamePlayer().getGameResult(winningTypes);

        assertThat(matchCountResults.keySet()).containsExactly(WinningType.EIGHTH, WinningType.SEVENTH, WinningType.SIXTH,
                WinningType.FIFTH, WinningType.FORTH, WinningType.THIRD, WinningType.SECOND, WinningType.FIRST);
        assertThat(matchCountResults.values()).containsExactly(0, 0, 1, 0, 0, 0, 2, 1);
    }

    @Test
    @DisplayName("보너스볼 입력 테스트")
    void inputBonusNumber_shouldNotIncludedWinningLottoNumber() {
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTickets userLottoTickets = new LottoTickets(1);
        assertThatThrownBy(()->new LottoGamePlayer().play(winningLottoTicket, userLottoTickets,1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
    }
}
