package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓 winningType 테스트")
    void checkWinningType() {
        WinningType winningType;
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");

        // 6개 모두 일치 시에는 1등
        LottoTicket userFirstLottoTicket = new LottoTicket("1,2,3,4,5,6");
        winningType = userFirstLottoTicket.getWinningType(winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FIRST);

        // 3개 일치 시에는 FORTH
        LottoTicket userForthLottoTicket = new LottoTicket("1,2,3,14,15,16");
        winningType = userForthLottoTicket.getWinningType(winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FORTH);

        // 0개 일치 시에는 SEVENTH
        LottoTicket userSeventhLottoNumbers = new LottoTicket("11,12,13,14,15,16");
        winningType = userSeventhLottoNumbers.getWinningType(winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.SEVENTH);

    }
}
