package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTests {

    @DisplayName(" LottoTickets 생성 테스트")
    @Test
    void create() {
        LottoTicket actualLottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTickets actualLottoTickets = LottoTickets.of(Arrays.asList(actualLottoTicket));


        assertThat(actualLottoTickets).isEqualTo(LottoTickets.of(
                Arrays.asList(
                        LottoTicket.of(
                                Arrays.asList(1, 2, 3, 4, 5, 6))
                ))
        );
    }

    @DisplayName("LottoTicket 들의 Rank 갯수를 잘 가져오는지 테스트")
    @Test
    void getMatchRankCountTest() {
        LottoTicket actualLottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTickets actualLottoTickets = LottoTickets.of(Arrays.asList(actualLottoTicket));

        Map<LottoRank, Integer> result = actualLottoTickets.getMatchRankCount(WinningLottoTicket.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7)));

        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);

    }


}
