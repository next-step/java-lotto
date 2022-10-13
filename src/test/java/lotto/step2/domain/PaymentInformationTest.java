package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PaymentInformationTest {
    private static final String EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    public final PaymentInformation paymentInformation = new PaymentInformation("14000");
    
    
    @Test
    @DisplayName("입력된 금액에 따른 로또 티켓 수")
    void numberOfTickets() {
        assertThat(paymentInformation.countOfAutoLotto()).isEqualTo(14);
    }
    
    @Test
    @DisplayName("지불 금액 확인")
    void checkPaymentPrice() {
        assertThat(paymentInformation.getPaymentPrice()).isEqualTo(14000);
    }
    
    @EmptySource
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("로또 구입 금액 - \"\" 입력 시 예외 던지기")
    void lotto_payment_price_input_null_or_empty_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentInformation(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"abcde", "!@#$%", "14000a"})
    void lotto_payment_price_input_number_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentInformation(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 입력 값이 1000원 단위가 아닐 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1400", "1001", "1234", "1100"})
    void lotto_payment_price_input_different_unit_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentInformation(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 0원 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "0000"})
    void lotto_payment_price_input_zero_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentInformation(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("로또 구입 금액 - 음수 입력 시")
    void lotto_payment_price_input_negative_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PaymentInformation("-1"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - 자동과 수동 로또 개수 구분")
    void input_count_of_manual_lotto() {
        paymentInformation.inputCountOfManualLotto("3");
        final int countOfAutoLotto = paymentInformation.countOfAutoLotto();
        final int countOfManualLotto = paymentInformation.countOfManualLotto();
        assertAll(
                () -> assertThat(countOfAutoLotto).isEqualTo(11),
                () -> assertThat(countOfManualLotto).isEqualTo(3)
        );
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - 음수 입력 시 예외")
    void input_count_of_manual_lotto_negative_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> paymentInformation.inputCountOfManualLotto("-1"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("수동 로또 개수 입력 - 소문자, 대문자 알파벳 및 한글 입력 시 예외")
    @ValueSource(strings = {"a", "A", "아"})
    void input_count_of_manual_lotto_alphabet_and_korean_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> paymentInformation.inputCountOfManualLotto(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - \"\" 입력 시 예외")
    void input_count_of_manual_lotto_empty_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> paymentInformation.inputCountOfManualLotto(""))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - 특수문자 입력 시 예외")
    void input_count_of_manual_lotto_special_characters_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> paymentInformation.inputCountOfManualLotto("%"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - 공백 입력 시 예외")
    void input_count_of_manual_lotto_space_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> paymentInformation.inputCountOfManualLotto(" "))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("수동 로또 개수 입력 - 공백 입력 시 예외")
    void input_count_of_manual_lotto_is_exceeded_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> paymentInformation.inputCountOfManualLotto("15"))
                .withMessage("로또 개수를 초과하였습니다. 다시 입력해주세요.");
    }
}