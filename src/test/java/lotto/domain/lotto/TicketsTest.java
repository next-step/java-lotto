package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.generator.LottoManualGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketsTest {

    private Ticket answerTicket;
    private Tickets tickets;
    private Number bonusNumber;

    @BeforeEach
    void setUp() {
        answerTicket = setUpAnswerTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        tickets = setUpTickets();
        bonusNumber = new Number(8);
    }

    @DisplayName("로또와 당첨번호, 보너스 번호가 주어졌을 때 각 티켓별 등수를 정확하게 파악할 수 있다.")
    @Test
    void testPrizeMapCorrectly() {
        Map<Rank, Integer> prizeMap = tickets.getComparisonPrizeMap(answerTicket, bonusNumber);
        assertAll(
            () -> assertThat(prizeMap.getOrDefault(Rank.FIRST, 0)).isZero(),
            () -> assertThat(prizeMap.getOrDefault(Rank.SECOND, 0)).isEqualTo(1),
            () -> assertThat(prizeMap.getOrDefault(Rank.THIRD, 0)).isZero(),
            () -> assertThat(prizeMap.getOrDefault(Rank.FOURTH, 0)).isEqualTo(1),
            () -> assertThat(prizeMap.getOrDefault(Rank.FIFTH, 0)).isZero(),
            () -> assertThat(prizeMap.getOrDefault(Rank.NONE, 0)).isEqualTo(1)
        );
    }

    private Ticket setUpAnswerTicket(List<Integer> numbers) {
        return new Ticket(numbers.stream().map(Number::new).collect(Collectors.toList()));
    }

    private Tickets setUpTickets() {
        return new Tickets(
            Arrays.asList(
                new Ticket(new LottoManualGenerator(1, 2, 3, 4, 5, 8).generateNumbers()),
                new Ticket(new LottoManualGenerator(3, 4, 5, 6, 10, 11).generateNumbers()),
                new Ticket(new LottoManualGenerator(13, 15, 22, 27, 38, 44).generateNumbers())
            )
        );
    }
}
