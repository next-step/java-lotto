package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoShopTest {
    @DisplayName("로또 금액 유효성 : 기본 가격 보다 낮을 경우 에러 발생 ")
    @ParameterizedTest
    @ValueSource(longs = {500, 700})
    void failureByLottoTicketPrice(long price) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoShop.validatePrice(price));
    }

    @DisplayName("로또 금액 유효성 : 기본 가격 보다 높을 경우 정상 진행 ")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000})
    void successByLottoTicketPrice(long price) {
        assertThatCode(()->LottoShop.validatePrice(price)).doesNotThrowAnyException();
    }

    @DisplayName("로또 구매시 티켓 갯수 유효성")
    @ParameterizedTest
    @MethodSource("numberOfTickets")
    void validateLottoTicketNumber(long lottoCounting, int numberOfTickets) {
        assertThat(LottoShop.publishLottoTickets(lottoCounting)).hasSize(numberOfTickets);
    }

    private static Stream<Arguments> numberOfTickets() {
        return Stream.of(
                Arguments.of(5, 5),
                Arguments.of(3, 3)
        );
    }
}
