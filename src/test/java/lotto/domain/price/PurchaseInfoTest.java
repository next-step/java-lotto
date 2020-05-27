package lotto.domain.price;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.AvailableCountExceedException;
import lotto.util.LottoTicketGenerator;
import lotto.util.LottoTicketsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PurchaseInfoTest {

    private LottoTickets manualTickets;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 4, 5, 6));
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 7, 8, 9));

        manualTickets = LottoTickets.of(lottoTickets);
    }

    @DisplayName("Price 가 null 이면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseInfo.valueOf(null, LottoTicketsGenerator.newInstance()));
    }

    @DisplayName("Price 와 수동 로또 번호를 인자로 입력받아 객체를 생성")
    @Test
    void create() {
        assertThatCode(() -> PurchaseInfo.valueOf(Price.of(Price.ONE_TICKET_PRICE), LottoTicketsGenerator.newInstance()))
                .doesNotThrowAnyException();
    }

    @DisplayName("수동으로 입력한 로또 티켓이 구매할 수 있는 티켓의 수보다 많으면 예외 반환")
    @Test
    void exceedOfAvailableCount() {
        Price price = Price.of(Price.ONE_TICKET_PRICE);

        assertThatExceptionOfType(AvailableCountExceedException.class)
                .isThrownBy(() -> PurchaseInfo.valueOf(price, manualTickets));
    }

    @DisplayName("남은 금액으로 구매할 수 있는 autoTickets 개수를 반환")
    @ParameterizedTest
    @MethodSource
    void getAutoTicketsCount(final Price price, final LottoTickets manualTickets, final int expected) {
        assertThat(PurchaseInfo.valueOf(price, manualTickets).getAutoTicketsCount())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> getAutoTicketsCount() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 4, 5, 6));
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 7, 8, 9));

        return Stream.of(
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE), LottoTicketsGenerator.valueOf(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE), LottoTicketsGenerator.newInstance(), 1),
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE * 4), LottoTickets.of(lottoTickets), 2),
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE * 10), LottoTickets.of(lottoTickets), 8)
        );
    }

    @DisplayName("구매한 manualTickets 개수를 반환")
    @ParameterizedTest
    @MethodSource
    void getManualTicketsCount(final Price price, final LottoTickets manualTickets, final int expected) {
        assertThat(PurchaseInfo.valueOf(price, manualTickets).getManualTicketsCount())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> getManualTicketsCount() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 4, 5, 6));
        lottoTickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 7, 8, 9));

        return Stream.of(
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE), LottoTicketsGenerator.newInstance(), 0),
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE), LottoTicketsGenerator.valueOf(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE * 4), LottoTickets.of(lottoTickets), 2)
        );
    }

    @DisplayName("수동 로또 번호 (LottoTickets)를 반환")
    @Test
    void getManualTickets() {
        Price price = Price.of(Price.ONE_TICKET_PRICE * 3);

        assertThat(PurchaseInfo.valueOf(price, manualTickets).getManualTickets())
                .isEqualTo(manualTickets);
    }
}
