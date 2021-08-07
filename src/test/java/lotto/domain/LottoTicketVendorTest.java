package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.NotEnoughMoneyException;
import lotto.ticketingway.AutoNumberGeneratingWay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketVendorTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1001,1", "1999,1", "2000,2", "2001,2"})
    @DisplayName("입력한 구입금액을 이용해 정해진 로또의 가격만큼 로또티켓을 구입할수있다.")
    void buy_lotto_tickets_auto(int money, int expectedTicketCount) {
        LottoTicketVendor vendor = new LottoTicketVendor(new AutoNumberGeneratingWay());

        List<LottoTicket> tickets = vendor.buyLottoTickets(money);
        assertThat(tickets.size()).isEqualTo(expectedTicketCount);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, 99, 999})
    @DisplayName("로또를 한장도 살수없는 금액이 입력되었을때는, 예외를 던진다.")
    void buy_lotto_tickets_not_enough_money(int money) {
        LottoTicketVendor vendor = new LottoTicketVendor(new AutoNumberGeneratingWay());

        assertThatThrownBy(() -> vendor.buyLottoTickets(money))
            .isInstanceOf(NotEnoughMoneyException.class);

    }

}