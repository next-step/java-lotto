package lotto.lotto;

import lotto.helper.Fixture;
import lotto.helper.Generator;
import lotto.money.Money;
import lotto.money.PaymentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.lotto.LottoMachine.PRICE_OF_A_TICKET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 판매 기계 클래스 테스트")
class LottoMachineTest {

    @DisplayName("구매 정봐와 수동 로또를 받고 추가적으로 구매 가능한 수의 자동 로또 티켓을 합친 로또를 반환한다.")
    @Test
    void buyLotto2() {
        int paymentValue = 10_000;
        Money payment = Money.from(10_000);
        LottoTickets manualLottoTickets = Generator.autoLottoTickets(5);
        PaymentInfo paymentInfo = PaymentInfo.of(payment, manualLottoTickets);

        Lotto lotto = LottoMachine.buy(paymentInfo, manualLottoTickets);

        assertThat(lotto).isNotNull();
        assertThat(lotto.getLottoTickets().size()).isEqualTo(paymentValue / PRICE_OF_A_TICKET.toInt());
    }

    @DisplayName("구매 정보나 수동 로또가 null 일 경우 예외를 발생 시킨다.")
    @MethodSource
    @ParameterizedTest
    void buyException2(PaymentInfo paymentInfo, LottoTickets lottoTickets) {
        assertThatThrownBy(() -> LottoMachine.buy(paymentInfo, lottoTickets)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> buyException2() {
        return Stream.of(
                Arguments.of(null, Generator.autoLottoTickets(1)),
                Arguments.of(Fixture.paymentInfo(), null),
                Arguments.of(null, null)
        );
    }
}
