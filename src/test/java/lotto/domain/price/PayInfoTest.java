package lotto.domain.price;

import lotto.domain.number.LottoNumber;
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

public class PayInfoTest {

    private List<List<LottoNumber>> manualTicketNumbers;

    @BeforeEach
    void setUp() {
        manualTicketNumbers = new ArrayList<>();
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5, 6));
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 7, 8, 9));
    }

    @DisplayName("Price 가 null 이면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PayInfo.valueOf(null, new ArrayList<>()));
    }

    @DisplayName("Price 와 수동 로또 번호를 인자로 입력받아 객체를 생성")
    @Test
    void create() {
        assertThatCode(() -> PayInfo.valueOf(Price.of(Price.ONE_TICKET_PRICE), new ArrayList<>()))
                .doesNotThrowAnyException();
    }

    @DisplayName("수동으로 입력한 로또 티켓이 구매할 수 있는 티켓의 수보다 많으면 예외 반환")
    @Test
    void exceedOfAvailableCount() {
        Price price = Price.of(Price.ONE_TICKET_PRICE);

        assertThatExceptionOfType(AvailableCountExceedException.class)
                .isThrownBy(() -> PayInfo.valueOf(price, manualTicketNumbers));
    }

    @DisplayName("남은 금액으로 구매할 수 있는 autoTickets 개수를 반환")
    @ParameterizedTest
    @MethodSource
    void getAutoTicketsCount(final Price price, final List<List<LottoNumber>> manualTicketNumber, final int expected) {
        assertThat(PayInfo.valueOf(price, manualTicketNumber).getAvailableAutoTicketsCount())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> getAutoTicketsCount() {
        List<List<LottoNumber>> manualTicketNumbers = new ArrayList<>();
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5, 6));
        manualTicketNumbers.add(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 7, 8, 9));

        return Stream.of(
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE), new ArrayList<>(), 1),
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE * 4), manualTicketNumbers, 2),
                Arguments.of(Price.of(Price.ONE_TICKET_PRICE * 10), manualTicketNumbers, 8)
        );
    }

    @DisplayName("수동 로또 번호 (LottoTickets)를 반환")
    @Test
    void getManualTicketNumbers() {
        Price price = Price.of(Price.ONE_TICKET_PRICE * 3);

        assertThat(PayInfo.valueOf(price, manualTicketNumbers)
                .getManualTicketNumbers().size())
                .isEqualTo(2);
    }
}
