package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("로또 티켓 병합 테스트")
    void mergeLottoTickets() {
        LottoTicket winningLottoTicket = new LottoTicket("7,8,9,10,11,12");
        int bonusNumber = 20;

        LottoTickets lottoTickets = new LottoTickets(new ArrayList<LottoTicket>(){{
            add(new LottoTicket("1,2,3,4,5,6"));
        }});

        //MISS
        List<WinningType> winningResult = lottoTickets.getWinningResult(winningLottoTicket,bonusNumber);
        assertThat(winningResult).containsExactly(WinningType.MISS);

        //1등 로또 티켓 추가
        List<LottoTicket> newLottoTickets = new ArrayList<LottoTicket>(){{
            add(new LottoTicket("7,8,9,10,11,12"));
        }};
        LottoTickets mergedLottoTickets = lottoTickets.addAll(newLottoTickets);

        //First가 추가되었기 때문에 MISS, First
        List<WinningType> mergedWinningResult = mergedLottoTickets.getWinningResult(winningLottoTicket,bonusNumber);
        assertThat(mergedWinningResult).containsExactly(WinningType.MISS, WinningType.FIRST);
    }
}
