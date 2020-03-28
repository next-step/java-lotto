package lotto.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsTest {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT3 = 3;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT4 = 4;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT5 = 5;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT6 = 6;

    List<Integer> luckyNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    List<LottoTicket> ticketList = new ArrayList<>(Arrays.asList(
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))),

            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 10))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 10))),

            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 10, 11, 12))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 11, 12, 13))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 20, 30, 45))),

            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24)))
    ));

    @DisplayName("생성자 테스트")
    @Test
    public void constructor() throws Exception {
        //given
        LottoTickets lottoTickets = new LottoTickets(ticketList);
    }

    @DisplayName("당첨 번호 일치 하는 로또 개수 비교")
    @Test
    public void LuckyNumberMatchCount() throws Exception {
        //given
        LottoTickets lottoTickets = new LottoTickets(ticketList);

        //then
        assertAll(
                () -> assertThat(lottoTickets.getLuckyNumberMatch3Count(luckyNumber))
                        .isEqualTo(3),
                () -> assertThat(lottoTickets.getLuckyNumberMatch4Count(luckyNumber))
                        .isEqualTo(0),
                () -> assertThat(lottoTickets.getLuckyNumberMatch5Count(luckyNumber))
                        .isEqualTo(2),
                () -> assertThat(lottoTickets.getLuckyNumberMatch6Count(luckyNumber))
                        .isEqualTo(2)
        );
    }
}
