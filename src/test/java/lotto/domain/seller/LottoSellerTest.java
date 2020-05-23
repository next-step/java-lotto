package lotto.domain.seller;

import lotto.domain.price.Price;
import lotto.domain.ticket.LottoTickets;
import lotto.util.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoSellerTest {

    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        lottoSeller = LottoSeller.newInstance();
    }

    @DisplayName("로또 1장의 가격보다 낮은 금액을 내면 예외가 발생")
    @Test
    void buyTicketFailureByLackMoney() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoSeller.buyTicket(Price.of(Price.ONE_TICKET_PRICE - 1), Generator.lottoTickets()));
    }

    @DisplayName("로또 구입 금액에 맞는 로또 티켓을 반환")
    @ParameterizedTest
    @MethodSource
    void buyTickets(final int money, final LottoTickets manualTickets, final int expected) {
        Price price = Price.of(money);
        assertThat(lottoSeller.buyTicket(price, manualTickets).getLottoTickets().size())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> buyTickets() {
        return Stream.of(
                Arguments.of(1000, Generator.lottoTickets(), 1),
                Arguments.of(14000, Generator.lottoTickets(Generator.lottoTicket(1, 2, 3, 4, 5, 6)), 14)
        );
    }
}
