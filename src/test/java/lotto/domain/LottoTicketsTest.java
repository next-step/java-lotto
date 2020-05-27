package lotto.domain;

import lotto.domain.result.LottoPrize;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningTicket;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
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
        LottoTickets lottoTickets = createLottoTickets();
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoTicket winningLottoTicket = new LottoTicket(new HashSet<>(lottoNumbers));
        WinningTicket winningTicket = new WinningTicket(winningLottoTicket, new LottoNumber(7));
        List<LottoPrize> expectedLottoPrizes = Arrays.asList(LottoPrize.FIRST, LottoPrize.SECOND, LottoPrize.FIFTH);

        //when
        LottoResult lottoResult = lottoTickets.getLottoResult(winningTicket);

        //then
        assertThat(lottoResult.getLottoStatistics()).isEqualTo(expectedLottoPrizes);
    }

    private LottoTickets createLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(new HashSet<>(of(Arrays.asList(1, 2, 3, 4, 5, 6)))); // 6
        LottoTicket lottoTicket2 = new LottoTicket(new HashSet<>(of(Arrays.asList(7, 1, 2, 4, 5, 6)))); // 5, bonus
        LottoTicket lottoTicket3 = new LottoTicket(new HashSet<>(of(Arrays.asList(1, 21, 3, 43, 12, 6)))); // 3

        return new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
    }

    private List<LottoNumber> of(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}
