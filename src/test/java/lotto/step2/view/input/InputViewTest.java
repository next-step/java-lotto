package lotto.step2.view.input;

import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.PaymentPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    private static final String EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    
    @Test
    @DisplayName("로또 구입 금액 입력 값 반환")
    void lotto_payment_price_input() {
        PaymentPrice paymentPrice = InputView.lottoPaymentPriceInput("14000");
        assertThat(paymentPrice).isEqualTo(new PaymentPrice(14000));
    }
    
    @NullAndEmptySource
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("로또 구입 금액 - null 또는 \"\" 입력 시 예외 던지기")
    void lotto_payment_price_input_null_or_empty_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentPriceInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"abcde", "!@#$%", "14000a"})
    void lotto_payment_price_input_number_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentPriceInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 입력 값이 1000원 단위가 아닐 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1400", "1001", "1234", "1100"})
    void lotto_payment_price_input_different_unit_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentPriceInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("로또 구입 금액 - 0원 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "0000"})
    void lotto_payment_price_input_zero_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentPriceInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("로또 구입 금액 - 음수 입력 시")
    void lotto_payment_price_input_negative_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.lottoPaymentPriceInput("-1"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("지난 주 당첨 번호 입력 값 반환")
    void winner_lotto_numbers_input() {
        List<LottoNumber> winningLottoNumbers = InputView.winningLottoNumbersInput("1, 5, 20, 39, 41, 45");
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(5), new LottoNumber(20), new LottoNumber(39), new LottoNumber(41), new LottoNumber(45));
        assertThat(winningLottoNumbers).isEqualTo(lottoNumbers);
    }
    
    @NullAndEmptySource
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("지난 주 당첨 번호 - null 또는 \"\" 입력 시 예외 던지기")
    void winner_lotto_numbers_input_null_or_empty_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.winningLottoNumbersInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("지난 주 당첨 번호 - 콤마 구분자가 아닌 경우 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1, 2, 3. 4, 5, 6", "1, 2, 3$ 4, 5, 6", "1, 2, 3,, 4, 5, 6"})
    void winner_lotto_numbers_input_delimiter_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.winningLottoNumbersInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("지난 주 당첨 번호 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1, 2, 3, 4, d, 6", "1, 2, 3, 4, , 6", "1, 2, 3, 4, %, 6"})
    void winner_lotto_numbers_input_number_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.winningLottoNumbersInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("지난 주 당첨 번호 - 음수 입력 시 예외 던지기")
    void winner_lotto_numbers_input_negative_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.winningLottoNumbersInput("1, 2, 3, 4, -5, 6"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("지난 주 당첨 번호 - 0 입력 시 예외 던지기")
    void winner_lotto_numbers_input_zero_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.winningLottoNumbersInput("1, 2, 0, 4, 5, 6"))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("지난 주 당첨 번호 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1, 2, 3 4, 5, 6", "1, 2, 3, 4, 5, ", "1, 2, 3, 4, 5"})
    void winner_lotto_numbers_input_different_format_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.winningLottoNumbersInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("보너스 당첨 번호 입력 값 반환")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"1", "45"})
    void winning_lotto_bonus_numbers_input(String input) {
        LottoNumber number = InputView.winningBonusLottoNumberInput(input);
        assertThat(number).isEqualTo(new LottoNumber(Integer.parseInt(input)));
    }
    
    @DisplayName("보너스 당첨 번호 - null 또는 \"\" 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @NullAndEmptySource
    void winning_lotto_bonus_numbers_input_null_or_empty_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.winningBonusLottoNumberInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("보너스 당첨 번호 - 숫자가 아닌 값 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"d", " ", "%"})
    void winning_lotto_bonus_numbers_input_number_format_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.winningBonusLottoNumberInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @DisplayName("보너스 당첨 번호 - 1 ~ 45 범위 초과")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "46"})
    void winning_lotto_bonus_numbers_input_range_exceed_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.winningBonusLottoNumberInput(input))
                .withMessage(EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("보너스 당첨 번호 - 음수 입력")
    void winning_lotto_bonus_numbers_input_negative_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> InputView.winningBonusLottoNumberInput("-1"))
                .withMessage(EXCEPTION_MESSAGE);
    }
}
