package lotto;

import lotto.domain.LottoTicketMachine;
import lotto.domain.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("구매 금액에 따라 티켓을 구매할 수 있다.")
    void shouldGenerateCorrectNumberOfTickets() {
        LottoTicketMachine machine = new LottoTicketMachine();
        int purchaseAmount = 5000;

        List<LottoTicket> tickets = machine.purchaseTickets(purchaseAmount);

        assertThat(tickets).hasSize(5);
    }

    @Test
    @DisplayName("생성된 티켓은 1부터 45 사이 숫자이며 중복되지 않는 번호를 가진다.")
    void shouldGenerateTicketWithSixUniqueNumbers() {
        LottoTicketMachine machine = new LottoTicketMachine();

        List<LottoTicket> tickets = machine.purchaseTickets(1000);

        for (LottoTicket ticket : tickets) {
            Set<Integer> numbers = ticket.getNumbers();

            assertThat(numbers)
                    .hasSize(6)
                    .allMatch(num -> num >= 1 && num <= 45);
        }
    }

}
