package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("입력받은 장수만큼 티켓이 발급됐는지 점검한다")
    @Test
    void create_tickets_as_per_input() {
        //Given
        int cnt = 10;
        //When
        LottoTickets tickets = new LottoTickets(10);
        //Then
        assertThat(tickets.counts()).isEqualTo(cnt);
    }

    @DisplayName("모든 티켓을 당첨번호와 비교한 결과 확인한다")
    @Test
    void match_all_tickets_with_winning_numbers() {
        //Given
        List<LottoNumber> firstNumbers = Arrays.asList(new LottoNumber(11), new LottoNumber(12),
                                                        new LottoNumber(13), new LottoNumber(17),
                                                        new LottoNumber(21), new LottoNumber(22));
        List<LottoNumber> secondNumbers = Arrays.asList(new LottoNumber(11), new LottoNumber(12),
                                                        new LottoNumber(13), new LottoNumber(33),
                                                        new LottoNumber(34), new LottoNumber(35));
        List<LottoTicket> lottoTicketList = Arrays.asList(new LottoTicket(firstNumbers),
                                                          new LottoTicket(secondNumbers));
        //When
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{11,12,13,17,44,45});
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        //Then
        LottoResult lottoResult = lottoTickets.matchingResultWith(winningNumbers);
        assertThat(lottoResult.getResultCount(MatchStatus.THREE)).isEqualTo(1);
        assertThat(lottoResult.getResultCount(MatchStatus.FOUR)).isEqualTo(1);

    }
}
