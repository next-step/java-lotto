package lottotests;

import lotto.model.wrapper.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("구입 금액 테스트")
public class PaymentTests {

    @DisplayName("Payment 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 17000, 54321})
    public void generatePaymentTest(int money) {
        assertThatCode(() -> Payment.of(money)).doesNotThrowAnyException();
    }

    @DisplayName("Payment 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -17000, -54321})
    public void generateMinusPaymentTest(int money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Payment.of(money))
                .withMessageContaining("payment must be greater than zero.");
    }

    @DisplayName("로또 구입 가능 숫자 테스트")
    @ParameterizedTest
    @CsvSource({"1000,1", "17000,17", "54321,54"})
    public void generateLottoNumberExceptionTest(int money, int expectedResult) {
        Payment payment = Payment.of(money);
        assertThat(payment.countLottoTicket()).isEqualTo(expectedResult);
    }
}
