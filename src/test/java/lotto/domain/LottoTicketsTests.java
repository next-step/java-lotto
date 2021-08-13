package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @DisplayName("LottoTicket 들에 당첨번호로 로또 결과를 잘 가져오는지 테스트")
    @Test
    void getMatchRankCountTest() {
        LottoTicket actualLottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTickets actualLottoTickets = LottoTickets.of(Arrays.asList(actualLottoTicket));

        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));


        LottoResult lottoResult = LottoResult.of(actualLottoTickets, winningLottoTicket);

        assertThat(actualLottoTickets.getMatchRankCount(winningLottoTicket)).isEqualTo(lottoResult);

    }


}
