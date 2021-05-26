package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓 생성")
    void generateLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets(5);

        //생성된 로또 티켓은 NULL이 될 수 없다.
        assertThat(lottoTickets).isNotNull();
    }

    @Test
    @DisplayName("로또 티켓 WinningType 리스트 확인")
    void getWinningType() {
        LottoTickets lottoTickets = new LottoTickets(1);

        //생성된 WinningType 리스트는 NULL이 될 수 없다.
        assertThat(lottoTickets.getWinningResult(new LottoTicket(), 1)).isNotNull();
    }

    @Test
    @DisplayName("로또 상금 합계 계산 테스트")
    void getPrizeSum() {
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
        int bonusNumber = 7;

        //1등, 2등 합계
        LottoTickets firstUserLottoTickets = new LottoTickets(Arrays.asList(
                new LottoTicket("1,2,3,4,5,6"), new LottoTicket("1,2,3,4,5,7")
        ));
        assertThat(firstUserLottoTickets.getPrizeSum(winningLottoTicket, bonusNumber))
                .isEqualTo(WinningType.FIRST.getPrize() + WinningType.SECOND.getPrize());

        //3등, 4등 합계
        LottoTickets secondUserLottoTickets = new LottoTickets(Arrays.asList(
                new LottoTicket("1,2,3,4,5,16"), new LottoTicket("1,2,3,4,15,17")
        ));
        assertThat(secondUserLottoTickets.getPrizeSum(winningLottoTicket, bonusNumber))
                .isEqualTo(WinningType.THIRD.getPrize() + WinningType.FORTH.getPrize());
    }
}
