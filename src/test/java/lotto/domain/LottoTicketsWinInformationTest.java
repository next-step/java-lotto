package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsWinInformationTest {

    @DisplayName("로또 당첨 번호를 전달하면 일치하는 개수가 몇 개 있는지 알 수 있다.")
    @Test
    void winningStatics() {
        //given
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 6", "45");

        LottoTicket lottoTicket1 = LottoTicket.from(1, 2, 3, 4, 5, 6); //1등
        LottoTicket lottoTicket2 = LottoTicket.from(1, 2, 3, 4, 5, 22); //3등
        List<LottoTicket> lottoTicketList = createLottoListFrom(lottoTicket1, lottoTicket2);
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList, 2000);
        LottoTicketsWinInformation lottoTicketsWinInformation = lottoTickets.winInformation(lottoWinningNumbers);

        //when
        Map<LottoRank, Integer> map = lottoTicketsWinInformation.winningStatics();

        //then
        assertThat(map.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(map.get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(map.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(map.get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(map.get(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(map.get(LottoRank.MISS)).isEqualTo(0);

    }

    private static List<LottoTicket> createLottoListFrom(LottoTicket... lottoTickets) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        Collections.addAll(lottoTicketList, lottoTickets);
        return lottoTicketList;
    }

    @DisplayName("LottoTickets 당첨금을 계산한다.")
    @Test
    void winningPrize() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 45;
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers, bonus);

        LottoTicket lottoTicket1 = LottoTicket.from(1, 2, 3, 4, 5, 45); //2등
        LottoTicket lottoTicket2 = LottoTicket.from(1, 2, 3, 33, 23, 22); //3등
        List<LottoTicket> lottoTicketList = createLottoListFrom(lottoTicket1, lottoTicket2);

        LottoTickets lottoTickets = new LottoTickets(lottoTicketList, 2000);
        LottoTicketsWinInformation lottoTicketsWinInformation = lottoTickets.winInformation(lottoWinningNumbers);

        //when
        int winningPrize = lottoTicketsWinInformation.winningPrize();

        //then
        assertThat(winningPrize).isEqualTo(30_005_000);

    }


    @DisplayName("LottoTickets 수익률 계산한다.")
    @Test
    void earningRate() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 45;
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers, bonus);

        LottoTicket lottoTicket1 = LottoTicket.from(1, 2, 3, 4, 5, 6); //1등
        LottoTicket lottoTicket2 = LottoTicket.from(1, 2, 3, 4, 5, 22); //3등
        List<LottoTicket> lottoTicketList = createLottoListFrom(lottoTicket1, lottoTicket2);

        LottoTickets lottoTickets = new LottoTickets(lottoTicketList, 2000);
        LottoTicketsWinInformation lottoTicketsWinInformation = lottoTickets.winInformation(lottoWinningNumbers);

        //when
        double earningRate = lottoTicketsWinInformation.earningRate();

        //then
        assertThat(earningRate).isEqualTo(1000750.0);
    }

}