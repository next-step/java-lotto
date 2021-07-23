package lotto.lotto;

import lotto.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.lotto.LottoMachine.PRICE_OF_A_TICKET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 판매 기계 클래스 테스트")
class LottoMachineTest {

    @DisplayName("돈을 받아 가능한 수의 로또 티켓을 가진 로또를 반환한다.")
    @Test
    void buyLotto() {
        int payment = 10_000;
        Lotto lotto = LottoMachine.buy(Money.init(payment));

        assertThat(lotto).isNotNull();
        assertThat(lotto.getLottoTickets().size()).isEqualTo(payment / PRICE_OF_A_TICKET.toInt());
    }

    @DisplayName("돈이 null 일 경우 예외를 발생 시킨다.")
    @Test
    void buyException() {
        assertThatThrownBy(() -> LottoMachine.buy(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
