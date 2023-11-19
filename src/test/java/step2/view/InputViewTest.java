package step2.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    @ParameterizedTest
    @CsvSource({ "900", "1", "160", "999", "1001"})
    void 입력된_금액을_검증하는_테스트(String moneyStr) {
        assertThatThrownBy(() -> InputView.parse(moneyStr)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"14000, 14", "15000, 15", "16000, 16", "17000, 17"})
    void 금액으로_티켓_수량을_구하는_테스트(int money, int tickets) {
        assertThat(InputView.getTicketCount(money)).isEqualTo(tickets);
    }
}