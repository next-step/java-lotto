package lotto.domain.model.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentTest {

    private LottoMoney money;

    @BeforeEach
    void setUp() {
        money = LottoMoney.of(14_000);
    }

    @ParameterizedTest(name = "{index} manual tickets = {0}, automatic tickets = {1}")
    @CsvSource({"0,14", "3,11", "14,0"})
    void countOfAutomatic(int countOfManual, int expected) {
        Payment payment = Payment.of(money, countOfManual);
        assertThat(payment.countOfAutomatic()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} Invalid countOfManual = {0}")
    @ValueSource(ints = {-1, 15})
    void of_InvalidCountOfManual(int countOfManual) {
        assertThatThrownBy(() -> Payment.of(money, countOfManual))
                .isInstanceOf(RuntimeException.class);
    }
}
