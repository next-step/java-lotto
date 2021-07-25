package lotto.money;

import lotto.helper.Generator;
import lotto.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("구매 정보를 담고 있는 클래스 테스트")
class PaymentInfoTest {

    @DisplayName("구매 정보는 구매 금액과 수동 로또 티켓을 가지고 초기화 한다.")
    @MethodSource
    @ParameterizedTest
    void init(Money payment, LottoTickets manualLottoTickets) {
        assertThat(PaymentInfo.of(payment, manualLottoTickets)).isNotNull();
    }

    private static Stream<Arguments> init() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Generator.autoLottoTickets(5)),
                Arguments.of(Money.from(5_000), Generator.autoLottoTickets(0))
        );
    }

    @DisplayName("구매 정보중 금액 혹은 수동 로또 티켓이 null 일 경우 예외를 던진다.")
    @MethodSource
    @ParameterizedTest
    void initException(Money payment, LottoTickets manualLottoNumbers) {
        assertThatThrownBy(() -> PaymentInfo.of(payment, manualLottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initException() {
        return Stream.of(
                Arguments.of(null, Generator.autoLottoTickets(5)),
                Arguments.of(Money.from(5_000), null),
                Arguments.of(null, null)
        );
    }

    @DisplayName("구매 금액은 수동 로또의 갯수 * 로또 하나 당 금액을 초과할 수 없다.")
    @MethodSource
    @ParameterizedTest
    void illegalStateOfInit(Money payment, LottoTickets manualLottoNumbers) {
        assertThatThrownBy(() -> PaymentInfo.of(payment, manualLottoNumbers)).isInstanceOf(IllegalStateException.class);
    }

    private static Stream<Arguments> illegalStateOfInit() {
        return Stream.of(
                Arguments.of(Money.from(5_000), Generator.autoLottoTickets(6)),
                Arguments.of(Money.from(5_000), Generator.autoLottoTickets(10))
        );
    }
}
