package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("Money 객체 전달받으면 로또를 발급한다.")
    void generateLotto() {
        Money money = new Money(5000);
        Lottos manualLottos = new Lottos(
                new ArrayList<>(List.of(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))))
        );
        Lottos lottos = lottoMachine.buyLotto(money, manualLottos);
        Assertions.assertThat(lottos.size()).isEqualTo(5);
    }
}
