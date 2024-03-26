package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoResultManagerTest {

    private LottoResultManager manager = new LottoResultManager();

    private List<LottoTicket> createLottoTickets() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoTicket.createTicket(List.of(1, 2, 3, 4, 5, 6)));
        tickets.add(LottoTicket.createTicket(List.of(11, 22, 33, 34, 35, 45)));
        tickets.add(LottoTicket.createTicket(List.of(10, 20, 30, 40, 43, 44)));
        tickets.add(LottoTicket.createTicket(List.of(13, 23, 33, 43, 44, 45)));
        return tickets;
    }

    @Test
    public void 당첨_결과() {
        List<LottoTicket> tickets = createLottoTickets();
        List<Integer> winningNumbers = List.of(11, 22, 33, 40, 43, 44);

        Map<Integer, Integer> result = manager.calculateLottoResult(tickets, winningNumbers);
        assertThat(result.get(3)).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource({"10000, 0.5", "15000,0.33"})
    public void 수익률(int amount, double expect) {
        Map<Integer, Integer> result = Map.of(0, 2, 1, 2, 2, 1, 3, 1);
        assertThat(manager.calculateReturnRate(result, amount)).isEqualTo(expect);
    }
}
