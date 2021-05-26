package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exceptions.CashOutOfBoundsException;
import lotto.exceptions.InvalidNumberException;

public class PurchaseTest {

    @DisplayName("로또를 구매한다.")
    @ParameterizedTest(name = "금액: \"{0}\", 티켓: \"{1}\"")
    @CsvSource(value = {"1000,1", "12345,12"})
    void totalTickets(String input, int expected) {
        Purchase purchase = new Purchase(input);
        assertThat(purchase.ticketsAmount()).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 문자열은 티켓 구매를 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    void createPurchase_InvalidNumber_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(() -> {
            new Purchase(input);
        });
    }

    @DisplayName("구입 가능 범위를 벗어나 티켓 구매를 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"999", "1000001"})
    void createPurchase_NumberOutOfBounds_ExceptionThrown(String input) {
        assertThatExceptionOfType(CashOutOfBoundsException.class).isThrownBy(() -> {
            new Purchase(input);
        });
    }

    @DisplayName("실제 결제금 계산")
    @ParameterizedTest(name = "지불: \"{0}\", 결제: \"{1}\"")
    @CsvSource(value = {"1000,1000", "12345,12000"})
    void payment(String input, int expected) {
        Purchase purchase = new Purchase(input);
        assertThat(purchase.payment()).isEqualTo(expected);
    }

}
