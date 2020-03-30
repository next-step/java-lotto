package lotto.domain.item;

import enums.LottoPrize;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsTest {

    WinLottoTicket winTicket = new WinLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

    List<LottoTicket> ticketList = new ArrayList<>(Arrays.asList(
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))),

            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 10))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 11))),

            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 11, 12))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 11, 12, 13))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 20, 30, 45))),

            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24)))
    ));

    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        LottoTickets lottoTickets = new LottoTickets(ticketList);
    }

    @DisplayName("당첨 번호 일치 하는 로또 개수 비교")
    @Test
    public void getXXXLottoCount_success() throws Exception {
        //given
        LottoTickets lottoTickets = new LottoTickets(ticketList);

        //then
        assertAll(
                () -> assertThat(lottoTickets.findWinLottoCountFromRank(LottoPrize.FIRST, winTicket))
                        .isEqualTo(2),
                () -> assertThat(lottoTickets.findWinLottoCountFromRank(LottoPrize.SECOND, winTicket))
                        .isEqualTo(1),
                () -> assertThat(lottoTickets.findWinLottoCountFromRank(LottoPrize.THIRD, winTicket))
                        .isEqualTo(1),
                () -> assertThat(lottoTickets.findWinLottoCountFromRank(LottoPrize.FOURTH, winTicket))
                        .isEqualTo(1)
        );
    }

    @DisplayName("총 상금 금액 계산")
    @Test
    public void getAllEarningPrize_success() throws Exception {
        //given
        List<LottoTicket> ticket = new ArrayList<>(
                Arrays.asList(
                        new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 12))),
                        new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 11, 12, 13))),
                        new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 20, 30, 45))))
        );
        LottoTickets lottoTickets = new LottoTickets(ticket);

        //when
        Money prize = lottoTickets.getAllEarningPrize(winTicket);

        //then
        assertAll(
                () -> assertThat(prize.getMoney()).isEqualTo(1_510_000)
        );
    }

    @DisplayName("로또 티켓 수량 비교")
    @Test
    public void getTickets_success() throws Exception {
        //given
        List<LottoTicket> ticket = new ArrayList<>(
                Arrays.asList(
                        new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 10, 11, 12))),
                        new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 11, 12, 13))),
                        new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 20, 30, 45))))
        );
        LottoTickets lottoTickets = new LottoTickets(ticket);

        //then
        assertThat(lottoTickets.getTickets().size()).isEqualTo(3);
    }

    @DisplayName("객체 복사 테스트")
    @Test
    public void clone_success() throws Exception {
        //given
        LottoTickets lottoTickets = new LottoTickets(ticketList);

        //when
        LottoTickets clone = (LottoTickets) lottoTickets.clone();

        //then
        assertThat(lottoTickets == clone).isFalse();
    }
}
