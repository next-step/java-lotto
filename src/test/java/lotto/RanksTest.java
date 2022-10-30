package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @Test
    void rankedWinningNumbers() {
        List<Ticket> ticketList = new ArrayList<>();
        Ticket ticket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        Ticket lottoWinningTicket = Ticket.of(Arrays.asList(3, 4, 5, 6, 7, 8));
        WinnigTicket winnigTicket = new WinnigTicket(lottoWinningTicket, 9);

        Ranks ranks = lotto.rankedWinningNumbers(winnigTicket);
        Map<Rank, Integer> rankMap = ranks.getRanks();

        assertThat(rankMap.get(Rank.FIFTH)).isEqualTo(0);
        assertThat(rankMap.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankMap.get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankMap.get(Rank.SECOND)).isEqualTo(0);
        assertThat(rankMap.get(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    void getTotalWinningAmount() {
        List<Ticket> ticketList = new ArrayList<>();
        Ticket ticket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        Ticket lottoWinningTicket = Ticket.of(Arrays.asList(3, 4, 5, 6, 7, 8));
        WinnigTicket winnigTicket = new WinnigTicket(lottoWinningTicket, 9);
        Ranks ranks = lotto.rankedWinningNumbers(winnigTicket);

        assertThat(ranks.getTotalWinningAmount()).isEqualTo(50000);

    }

    @ParameterizedTest(name = "{index}. 번호매칭 - args : [{arguments}]")
    @CsvSource(value = {"1,2,3,4,5,6:2000000000",
            "2,3,4,5,6,9:30000000",
            "2,3,4,5,6,7:1500000",
            "3,4,5,6,7,8:50000",
            "4,5,6,7,8,9:5000",
            "5,6,7,8,9,10:0"}, delimiter = ':')
    void getTotalWinningAmount(String ticketNumberText, int expected) {

        String[] tokens = ticketNumberText.split(",");
        List<Integer> ticketNumbers = Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Ticket ticket = Ticket.of(ticketNumbers);

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        Ticket lottoWinningTicket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinnigTicket winnigTicket = new WinnigTicket(lottoWinningTicket, 9);
        Ranks ranks = lotto.rankedWinningNumbers(winnigTicket);

        assertThat(ranks.getTotalWinningAmount()).isEqualTo(expected);
    }

    @Test
    void caculateIncomePercentage() {
        List<Ticket> ticketList = new ArrayList<>();
        Ticket ticket = Ticket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        Ticket lottoWinningTicket = Ticket.of(Arrays.asList(3, 4, 5, 6, 7, 8));
        WinnigTicket winnigTicket = new WinnigTicket(lottoWinningTicket, 9);
        Ranks ranks = lotto.rankedWinningNumbers(winnigTicket);

        assertThat(ranks.caculateIncomePercentage()).isEqualTo(50);
    }
}
