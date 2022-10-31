package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "15000,15"})
    void 장당_1000원일때(int moneyToBuyTicket, int numberOfTickets) {
        assertThat(LottoGame.buy(moneyToBuyTicket).size()).isEqualTo(numberOfTickets);
    }
}
