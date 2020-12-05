package lotto;

import lotto.domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("구입금액, 로또 가격으로 수량을 계산한다")
    @CsvSource(value = {"14000:14", "14500:14"}, delimiter = ':')
    public void calculate_lotto_ticket(int input, int result) {
        assertThat(calculator.calculateLottoTicketCount(input)).isEqualTo(result);
    }

    @Test
    @DisplayName("구입금액이 로또가격보다 낮은 경우 예외가 발생한다")
    public void fail_to_buy() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculateLottoTicketCount(900));
    }

    @Test
    @DisplayName("로또 티켓 수량, 수동 로또 티켓 수량으로 자동 티켓 수량을 계산한다")
    public void get_auto_lotto_ticket_count() {
        assertThat(calculator.getAutoLottoCount(5, 3)).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 로또 티켓 수량이 로또 티켓 수량보다 큰 경우에 예외가 발생한다")
    public void manual_lotto_ticket_count_bigger_than_lotto_ticket_count() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.getAutoLottoCount(2, 3));
    }

    @Test
    @DisplayName("수동 로또 티켓 수량이 로또 티켓 수량보다 큰 경우에 예외가 발생한다")
    public void manual_lotto_ticket_count_negative() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.getAutoLottoCount(2, -1));
    }
}
