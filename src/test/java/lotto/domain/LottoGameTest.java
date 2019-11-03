package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    void 로또_구입() {
        assertThat(new LottoGame(14000).getToStringTickets().size()).isEqualTo(14);
        assertThat(new LottoGame(0).getToStringTickets().size()).isEqualTo(0);
        assertThat(new LottoGame(1100).getToStringTickets().size()).isEqualTo(1);
    }

    @Test
    void 당첨번호_확인() {
        List<LottoTicket> tickets = Arrays.asList(
                new LottoTicket("1,2,3,4,5,6"),
                new LottoTicket("1,2,3,14,15,16"),
                new LottoTicket("11,12,13,14,15,16")
        );
        LottoGame game = new LottoGame(tickets);
        assertThat(game.getWinStatistics("1,2,3,4,5,6")).isEqualTo(new int[]{1, 0, 0, 1, 0, 0, 1});
    }

}
