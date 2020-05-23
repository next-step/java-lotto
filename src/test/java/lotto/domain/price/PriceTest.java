package lotto.domain.price;

import lotto.exception.NegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PriceTest {

    @DisplayName("입력받은 금액이 티켓 1장 이상의 금액이면 Price 객체를 생성")
    @ParameterizedTest
    @ValueSource(ints = { Price.ONE_TICKET_PRICE, Price.ONE_TICKET_PRICE * 2 })
    void create(final int price) {
        assertThatCode(() -> Price.of(price))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력받은 금액이 음수이면 예외가 발생")
    @Test
    void createFailure() {
        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> Price.of(Price.MIN_PRICE - 1));
    }

    @DisplayName("입력받은 금액이 티켓 1장을 금액보다 적으면 예외가 발생")
    @Test
    void validateAvailablePrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Price.of(Price.ONE_TICKET_PRICE - 1).validateAvailablePrice());
    }

    @DisplayName("구입가능한 티켓의 개수를 반환")
    @ParameterizedTest
    @MethodSource
    void ticketCount(final int price, final int expected) {
        assertThat(Price.of(price).ticketCount()).isEqualTo(expected);
    }

    private static Stream<Arguments> ticketCount() {
        return Stream.of(
                Arguments.of(Price.ONE_TICKET_PRICE, 1),
                Arguments.of(Price.ONE_TICKET_PRICE * 14, 14),
                Arguments.of(Price.ONE_TICKET_PRICE * 14 + 100, 14)
        );
    }
}
