package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    @DisplayName("정상적인 금액으로 로또를 구매하면 금액 / 1000 만큼 생성된다")
    void buyLotto_success() {
        LottoMachine machine = new LottoMachine();
        long amount = 5000;

        List<LottoNumbers> lottos = machine.buy(amount);

        assertThat(lottos).hasSize(5);
        assertThat(lottos).allSatisfy(lotto -> assertThat(lotto.numbers()).hasSize(6));
    }

    @Test
    @DisplayName("1000원 미만의 금액으로는 로또를 구매할 수 없다")
    void buyLotto_failUnderMinimum() {
        LottoMachine machine = new LottoMachine();

        assertThatThrownBy(() -> machine.buy(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 1,000원 이상 입력해야 합니다.");
    }

    @Test
    @DisplayName("정확히 1000원을 입력하면 로또 1장을 구매할 수 있다")
    void buyLotto_exactMinimum() {
        LottoMachine machine = new LottoMachine();

        List<LottoNumbers> lottos = machine.buy(1000);

        assertThat(lottos).hasSize(1);
    }
}
