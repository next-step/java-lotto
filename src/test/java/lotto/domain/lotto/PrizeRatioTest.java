package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeRatioTest {

    private static final int BASE_BONUS_NUMBER = 7;
    private static final int PRICE_PER_TICKET = 1000;
    private static final double RATE_RETURNS = 0.35;

    private Answer answer;
    private Tickets tickets;

    @BeforeEach
    void setUp() {
        setUpTickets();
        setUpAnswer();
    }

    private void setUpTickets() {
        List<List<Integer>> lottoTickets = Arrays.asList(
            Arrays.asList(8, 21, 23, 41, 42, 43),
            Arrays.asList(3, 5, 11, 16, 32, 38),
            Arrays.asList(7, 11, 16, 35, 36, 44),
            Arrays.asList(1, 8, 11, 31, 41, 42),
            Arrays.asList(13, 14, 16, 38, 42, 45),
            Arrays.asList(7, 11, 30, 40, 42, 43),
            Arrays.asList(2, 13, 22, 32, 38, 45),
            Arrays.asList(23, 25, 33, 36, 39, 41),
            Arrays.asList(1, 3, 5, 14, 22, 45),
            Arrays.asList(5, 9, 38, 41, 43, 44),
            Arrays.asList(2, 8, 9, 18, 19, 21),
            Arrays.asList(13, 14, 18, 21, 23, 35),
            Arrays.asList(17, 21, 29, 37, 42, 45),
            Arrays.asList(3, 8, 27, 30, 35, 44)
        );

        List<Ticket> ticketList = new ArrayList<>();
        for (List<Integer> ticketNumbers: lottoTickets) {
            Ticket ticket = new Ticket(new Numbers(ticketNumbers.stream().map(Number::new).collect(
                Collectors.toList())));
            ticketList.add(ticket);
        }

        tickets = new Tickets(ticketList);
    }

    private void setUpAnswer() {
        Numbers baseAnswerNumbers = new Numbers(Stream.of(1, 2, 3, 4, 5, 6)
            .map(Number::new)
            .collect(Collectors.toList()));
        answer = new Answer(baseAnswerNumbers, BASE_BONUS_NUMBER);
    }

    private int getPurchased() {
        return PRICE_PER_TICKET * tickets.count();
    }

    @DisplayName("수익률 유효성 검증")
    @Test
    void testRateReturnsValid() {
        BigDecimal rateOfReturn = new PrizeRatio().calculateRatio(getPurchased(), answer.getComparisonPrizeMap(tickets));

        assertThat(rateOfReturn.doubleValue())
            .isEqualTo(RATE_RETURNS);
    }
}
