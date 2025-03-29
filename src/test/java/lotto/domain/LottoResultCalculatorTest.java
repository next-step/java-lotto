package lotto.domain;

import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {

    @Test
    @DisplayName("로또의 순위를 구할 수 있다.")
    void shouldCalculateCorrectRanksForAllTickets() {
        LottoResultCalculator calculator = new LottoResultCalculator();
        LottoTicket winningTicket = createTicket(1, 2, 3, 4, 5, 6);

        List<LottoTicket> tickets = Arrays.asList(
                createTicket(1, 2, 3, 4, 5, 6),
                createTicket(1, 2, 3, 4, 5, 7),
                createTicket(1, 2, 3, 4, 8, 9),
                createTicket(1, 2, 3, 8, 9, 10)
        );

        LottoResult result = calculator.calculate(tickets, winningTicket);
        assertThat(result.getRankCounts())
                .containsEntry(Rank.FIRST, 1)
                .containsEntry(Rank.THIRD, 1)
                .containsEntry(Rank.FOURTH, 1);
    }

    @Test
    @DisplayName("일치하는 번호가 없는 로또는 MISS 순위를 반환한다.")
    void shouldHandleTicketsWithNoMatches() {
        LottoResultCalculator calculator = new LottoResultCalculator();
        LottoTicket winningTicket = createTicket(1, 2, 3, 4, 5, 6);

        List<LottoTicket> tickets = List.of(createTicket(7, 8, 9, 10, 11, 12));

        LottoResult result = calculator.calculate(tickets, winningTicket);
        assertThat(result.getRankCounts()).isEqualTo(Map.of(Rank.MISS, 1));
    }

    private LottoTicket createTicket(final int... numbers) {
        Set<LottoNumber> numberSet = new HashSet<>();
        for (int number : numbers) {
            numberSet.add(new LottoNumber(number));
        }
        return new LottoTicket(numberSet);
    }
}
