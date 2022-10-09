package lottogame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lottogame.domain.strategy.RangeLottoNumberPickerStrategy;
import lottogame.domain.user.User;

class TicketSellerTest {
    @ParameterizedTest(name = "사용자가 자동모드로 최대한 티켓을 사고 남은 잔돈과 티켓 수를 검증한다, 소유액: {0}, 티켓 수: {1}, 잔액: {2}")
    @CsvSource(value = {
        "12005, 12, 5",
        "10000, 10, 0",
        "12, 0, 12"
    })
    void sellAutomaticTicketTo(int money, int ticketCount, int change) {
        User user = new User(new Money(money), TicketSeller.getTicketPrice());
        TicketSeller.sellAutomaticTicketTo(user);

        assertThat(user.getMoney()).isEqualTo(new Money(change));
        assertThat(user.getLottoTickets().size()).isEqualTo(ticketCount);
    }

    @ParameterizedTest(name = "사용자가 수동모드로 티켓을 사고 남은 잔돈과 티켓 수를 검증한다, 소유액: {0}, 티켓 수: {1}, 잔액: {2}")
    @CsvSource(value = {
        "12005, 1, 11005",
        "10000, 1, 9000",
        "12, 0, 12"
    })
    void sellManualTicketTo(int money, int ticketCount, int change) {
        User user = new User(new Money(money), TicketSeller.getTicketPrice());
        TicketSeller.sellManualTicketTo(user, new RangeLottoNumberPickerStrategy());

        assertThat(user.getMoney()).isEqualTo(new Money(change));
        assertThat(user.getLottoTickets().size()).isEqualTo(ticketCount);
    }
}
