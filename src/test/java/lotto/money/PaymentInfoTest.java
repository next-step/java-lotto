package lotto.money;

import lotto.helper.Generator;
import lotto.lotto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구매 정보를 담고 있는 클래스 테스트")
class PaymentInfoTest {

    @DisplayName("구매 정보는, 구매 금액과 수동 로또 티켓을 가지고 초기화 한다.")
    @MethodSource
    @ParameterizedTest
    void init(Money payment, LottoTickets manualLottoNumbers) {
        assertThat(PaymentInfo.of(payment, manualLottoNumbers)).isNotNull();
    }

    private static Stream<Arguments> init() {
        return Stream.of(
                Arguments.of(Money.from(5000), Generator.autoLottoTickets(5)),
                Arguments.of(Money.from(5000), Generator.autoLottoTickets(2))
        );
    }
}
