package Lotto.Game;

import Lotto.Ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구입 금액은")
public class PaymentsTest {

    @DisplayName("1000의 배수로 초기화 된다.")
    @Test
    void mustBeMultipleOf1000() {
        Payments payments = new Payments(LottoTicket.PRICE);
        assertThat(payments).isInstanceOf(Payments.class);
    }


    @DisplayName("1000의 배수가 아닐 경우: IllegalArgumentException 예외 던짐.")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> new Payments(999)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("구매 금액은 1000의 배수이어야 합니다.");
    }

    @DisplayName("양의 정수이다.")
    @ParameterizedTest(name = "인풋 {0}에 대해 예외 던짐")
    @ValueSource(ints = {-1000, 0})
    void isPositiveInteger(int payments) {
        assertThatThrownBy(() -> new Payments(payments)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("구매 금액은 양수입니다.");
    }
}
