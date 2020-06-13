package step2.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import lotto.model.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PaymentTest {

    @DisplayName("금액 생성 오류 테스트")
    @ParameterizedTest
    @MethodSource("createPaymentExceptionTestCases")
    public void createPaymentExceptionTest(int money) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Payment.of(money, 1))
            .withMessageContaining("금액은 0 이상의 값으로 입력해주세요.");
    }

    private static Stream<Arguments> createPaymentExceptionTestCases() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(-1000)
        );
    }

    @DisplayName("수동 로또를 금액보다 많이 구매 했을 때 오류 테스트")
    @ParameterizedTest
    @MethodSource("createPaymentByManyManualLottoTicketExceptionTestCases")
    public void createPaymentByManyManualLottoTicketExceptionTest(int money, int countOfManualLottoTicket) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Payment.of(money, countOfManualLottoTicket).getCountOfTotalLottoTicket())
            .withMessageContaining("구매 금액보다 수동으로 구매할 로또의 수가 많습니다. 금액을 확인해 주세요.");
    }

    private static Stream<Arguments> createPaymentByManyManualLottoTicketExceptionTestCases() {
        return Stream.of(
            Arguments.of(1000, 2),
            Arguments.of(2000, 3)
        );
    }
}