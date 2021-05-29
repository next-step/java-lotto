package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTicketTest {

    @Test
    @DisplayName("로또 티켓 WinningType 리스트 확인")
    void getWinningType() {
        WinningLottoTicket lottoTickets = new WinningLottoTicket(new LottoTicket(), new LottoNumber(1));

        //생성된 WinningType 리스트는 NULL이 될 수 없다.
        assertThat(lottoTickets.getWinningResult(new ArrayList<LottoTicket>() {{
            add(new LottoTicket());
            add(new LottoTicket());
        }})).isNotNull();
    }

    @Test
    @DisplayName("로또 상금 합계 계산 테스트")
    void getPrizeSum() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), new LottoNumber(7));

        //1등, 2등 합계
        List<LottoTicket> firstUserLottoTickets = Arrays.asList(
                new LottoTicket("1,2,3,4,5,6"), new LottoTicket("1,2,3,4,5,7")
        );
        assertThat(winningLottoTicket.getPrizeSum(firstUserLottoTickets))
                .isEqualTo(WinningType.FIRST.getPrize() + WinningType.SECOND.getPrize());

        //3등, 4등 합계
        List<LottoTicket> secondUserLottoTickets = Arrays.asList(
                new LottoTicket("1,2,3,4,5,16"), new LottoTicket("1,2,3,4,15,17")
        );
        assertThat(winningLottoTicket.getPrizeSum(secondUserLottoTickets))
                .isEqualTo(WinningType.THIRD.getPrize() + WinningType.FORTH.getPrize());

    }

    @Test
    @DisplayName("보너스볼 입력 테스트")
    void inputBonusNumber_shouldNotIncludedWinningLottoNumber() {
        assertThatThrownBy(()->new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), new LottoNumber(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
    }
}
