package lottery.domain.factory;

import lottery.domain.LottoTickets;
import lottery.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsDispenseTest {

    @Test
    @DisplayName("로또 발행 테스트")
    void dispenseTest(){
        final Money money = new Money(3000);
        final List<String> manualNumbersStrings = List.of(
                "1, 2, 3, 4, 5, 6",
                "2, 3, 4, 5, 6, 7");

        LottoTickets actual = LottoTicketsDispenser.dispense(money, manualNumbersStrings);

        assertThat(actual.lottoTickets()).hasSize(3);
        assertThat(actual.manualTicketCount()).isEqualTo(2L);
        assertThat(actual.quickTicketCount()).isEqualTo(1L);
    }
}
