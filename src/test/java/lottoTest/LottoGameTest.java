package lottoTest;

import lotto.LottoGame;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    LottoGame lottoGame = new LottoGame();

    @DisplayName("구입 금액 요청 - 로또 티켓을 얼마나 살지 결정.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "500, 0", "1440, 1", "0, 0"})
    public void purchaseLottoTicket(int budget, int expected) {
        int num = lottoGame.setTicketNumber(budget);
        assertThat(num).isEqualTo(expected);
    }

    @DisplayName("구입한 갯수 만큼 로또 티켓 생성.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void testNumberOfTicket(int numOfPurchase) {
        List<LottoTicket> ticketList = lottoGame.buyTickets(numOfPurchase);
        assertThat(ticketList.size()).isEqualTo(numOfPurchase);
    }
}
