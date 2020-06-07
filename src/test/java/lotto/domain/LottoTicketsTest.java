package lotto.domain;

import lotto.domain.result.LottoPrize;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningTicket;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.support.LottoNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTicketsTest {

    @DisplayName("당첨번호를 입력하면 당첨통계를 반환한다")
    @Test
    void resultTest() {
        //given
        LottoTickets userTickets = createLottoTickets();
        WinningTicket winningTicket = createWinningTicket();
        List<LottoPrize> expectedLottoPrizes = Arrays.asList(LottoPrize.FIRST, LottoPrize.SECOND, LottoPrize.FIFTH);

        //when
        LottoResult lottoResult = userTickets.getLottoResult(winningTicket);

        //then
        assertThat(lottoResult.getLottoStatistics()).isEqualTo(expectedLottoPrizes);
    }

    private WinningTicket createWinningTicket() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        LottoTicket winningLottoTicket = new LottoTicket(new HashSet<>(lottoNumbers));
        return new WinningTicket(winningLottoTicket, LottoNumber.of(7));
    }

    private LottoTickets createLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 6))); // 6
        LottoTicket lottoTicket2 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(7, 1, 2, 4, 5, 6))); // 5, bonus
        LottoTicket lottoTicket3 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 21, 3, 43, 12, 6))); // 3

        return new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
    }


}
