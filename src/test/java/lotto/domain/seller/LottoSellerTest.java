package lotto.domain.seller;

import lotto.domain.number.LottoNumber;
import lotto.domain.price.PayInfo;
import lotto.domain.price.Price;
import lotto.exception.AvailableCountExceedException;
import lotto.util.LottoNumbersGenerator;
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

public class LottoSellerTest {

    private List<List<LottoNumber>> manualTicketNumbers;

    @BeforeEach
    void setUp() {
        manualTicketNumbers = new ArrayList<>();
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5, 6));
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 7, 8, 9));
    }

    @DisplayName("PayInfo 가 null 이면 예외를 반환")
    @Test
    void buyTicketFailureByNullArgument2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoSeller.buyTicket(null));
    }

    @DisplayName("로또 1장의 가격보다 낮은 금액을 내면 예외가 발생")
    @Test
    void buyTicketFailureByLackMoney2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        LottoSeller.buyTicket(
                                PayInfo.valueOf(
                                        Price.of(Price.ONE_TICKET_PRICE - 1), new ArrayList<>())
                        ));
    }

    @DisplayName("로또 구입 금액에 맞는 로또 티켓을 반환")
    @ParameterizedTest
    @MethodSource
    void buyTickets2(final int money, final List<List<LottoNumber>> manualTicketNumbers, final int expected) {
        PayInfo payInfo = PayInfo.valueOf(Price.of(money), manualTicketNumbers);

        assertThat(LottoSeller.buyTicket(payInfo).getAllTickets().count())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> buyTickets2() {
        List<List<LottoNumber>> manualTicketNumbers = new ArrayList<>();
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5, 6));
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 7, 8, 9));

        return Stream.of(
                Arguments.of(1000, new ArrayList<>(), 1),
                Arguments.of(14000, manualTicketNumbers, 14)
        );
    }

    @DisplayName("수동으로 입력한 로또 티켓이 구매할 수 있는 티켓의 수보다 많으면 예외 반환")
    @Test
    void buyTicketsFailure2() {
        Price price = Price.of(Price.ONE_TICKET_PRICE);

        List<List<LottoNumber>> manualTicketNumbers = new ArrayList<>();
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5, 6));
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 7, 8, 9));

        assertThatExceptionOfType(AvailableCountExceedException.class)
                .isThrownBy(() -> LottoSeller.buyTicket(PayInfo.valueOf(price, manualTicketNumbers)));
    }
}
