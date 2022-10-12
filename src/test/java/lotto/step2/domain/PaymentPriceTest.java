package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PaymentPriceTest {
    private static final String EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    public final PaymentPrice paymentPrice = new PaymentPrice("14000");
    
    
    @Test
    @DisplayName("입력된 금액에 따른 로또 티켓 수")
    void numberOfTickets() {
        assertThat(paymentPrice.countOfAutoLotto()).isEqualTo(14);
    }
    
    @Test
    @DisplayName("지불 금액 확인")
    void checkPaymentPrice() {
        assertThat(paymentPrice.getPaymentPrice()).isEqualTo(14000);
    }
    
    @EmptySource
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("로또 구입 금액 - \"\" 입력 시 예외 던지기")
    void lotto_payment_price_input_null_or_empty_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentPrice(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"abcde", "!@#$%", "14000a"})
    void lotto_payment_price_input_number_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentPrice(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 입력 값이 1000원 단위가 아닐 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1400", "1001", "1234", "1100"})
    void lotto_payment_price_input_different_unit_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentPrice(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 0원 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "0000"})
    void lotto_payment_price_input_zero_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentPrice(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("로또 구입 금액 - 음수 입력 시")
    void lotto_payment_price_input_negative_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentPrice("-1"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - 자동과 수동 로또 개수 구분")
    void input_count_of_manual_lotto() {
        paymentPrice.inputCountOfManualLotto("3");
        final int countOfAutoLotto = paymentPrice.countOfAutoLotto();
        final int countOfManualLotto = paymentPrice.countOfManualLotto();
        assertAll(
                () -> assertThat(countOfAutoLotto).isEqualTo(11),
                () -> assertThat(countOfManualLotto).isEqualTo(3)
        );
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - 음수 입력 시 예외")
    void input_count_of_manual_lotto_negative_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> paymentPrice.inputCountOfManualLotto("-1"))
                .withMessage(EXCEPTION_MESSAGE);
    }
}