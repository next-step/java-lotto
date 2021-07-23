package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 판매 기계 클래스 테스트")
class LottoMachineTest {

    @DisplayName("돈을 받아 가능한 수의 로또 티켓을 가진 로또를 반환한다.")
    @Test
    void buyLotto() {
        assertThat(LottoMachine.buy(10_000)).isInstanceOf(Lotto.class);
    }

}
