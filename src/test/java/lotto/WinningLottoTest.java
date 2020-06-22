package lotto;

import lotto.domain.CustomLottoTicket;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("계산한 Rank의 리스트가 실제 구매 티켓과 담청 티켓의 매칭 결과와 일치하는 지 테스트")
    void IsRankEqualWithMatchingOfBuyingTicketAndWinningTicket() {
        CustomLottoTicket winningLottoTicket = new CustomLottoTicket(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        WinningLotto winningLotto = new WinningLotto(winningLottoTicket);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new CustomLottoTicket(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))));
        lottoTickets.add(new CustomLottoTicket(new ArrayList<>(Arrays.asList(1,2,3,4,7,8))));
        lottoTickets.add(new CustomLottoTicket(new ArrayList<>(Arrays.asList(11,12,13,14,15,16))));

        List<Rank> actual = winningLotto.getLottoRank(lottoTickets);
        List<Rank> expected = new ArrayList<>(Arrays.asList(Rank.FIRST, Rank.THIRD, Rank.MISS));

        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i)).isEqualTo(expected.get(i));
        }
    }
}
