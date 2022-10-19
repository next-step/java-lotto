package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void convertAmountToTicketCount() {
        int amount = 14000;

        assertThat(Lotto.convertAmountToTicketCount(amount)).isEqualTo(14);
    }

    @Test
    void getTicketCount() {
        int amount = 14000;
        Lotto lotto = new Lotto(amount);

        assertThat(lotto.getTicketCount()).isEqualTo(14);
    }



    @Test
    void makeTicketList() {
        List<Ticket> lottoTickets = Lotto.makeTicketList(5);

        assertThat(lottoTickets).hasSize(5);
    }

    @Test
    void getTicketList() {
        int amount = 14000;
        Lotto lotto = new Lotto(amount);

        assertThat(lotto.getTicketList()).hasSize(14);
    }

    @ParameterizedTest(name = "{index}. 번호매칭 - args : [{arguments}]")
    @CsvSource(value = {"1,2,3,4,5,6:6",
            "2,3,4,5,6,7:5",
            "3,4,5,6,7,8:4",
            "4,5,6,7,8,9:3",
            "5,6,7,8,9,10:2"}, delimiter = ':')
    void checkWinningNumbers(String ticketNumberText, int expected) {
        List<Integer> lottoWinnigNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String[] tokens = ticketNumberText.split(",");
        List<Integer> ticketNumbers = Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Ticket ticket = new Ticket(ticketNumbers);

        int matchCount = Lotto.getWinningNumbersMatchCount(lottoWinnigNumbers, ticket);
        assertThat(matchCount).isEqualTo(expected);
    }

    @Test
    void increaseMatchCount() {
        List<Integer> lottoWinnigNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int matchCount = 0;

        matchCount = Lotto.increaseMatchCount(lottoWinnigNumbers, 1, matchCount);
        assertThat(matchCount).isEqualTo(1);

        matchCount = Lotto.increaseMatchCount(lottoWinnigNumbers, 2, matchCount);
        assertThat(matchCount).isEqualTo(2);

        matchCount = Lotto.increaseMatchCount(lottoWinnigNumbers, 7, matchCount);
        assertThat(matchCount).isEqualTo(2);
    }

    @Test
    void increaseRankMatchCount() {
        Lotto lotto = new Lotto(1000);

        lotto.increaseRankMatchCount(3);
        assertThat(lotto.getThreeMatchRankCount()).isEqualTo(1);
        lotto.increaseRankMatchCount(3);
        assertThat(lotto.getThreeMatchRankCount()).isEqualTo(2);
        lotto.increaseRankMatchCount(4);
        assertThat(lotto.getFourMatchRankCount()).isEqualTo(1);
        lotto.increaseRankMatchCount(5);
        assertThat(lotto.getFiveMatchRankCount()).isEqualTo(1);
        lotto.increaseRankMatchCount(6);
        assertThat(lotto.getSixMatchRankCount()).isEqualTo(1);
    }

    @Test
    void rankedWinningNumbers() {
        List<Ticket> ticketList = new ArrayList<>();
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(ticketNumbers);
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        List<Integer> lottoWinnigNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        lotto.rankedWinningNumbers(lottoWinnigNumbers);

        assertThat(lotto.getThreeMatchRankCount()).isEqualTo(0);
        assertThat(lotto.getFourMatchRankCount()).isEqualTo(1);
        assertThat(lotto.getFiveMatchRankCount()).isEqualTo(0);
        assertThat(lotto.getSixMatchRankCount()).isEqualTo(0);
    }
}
