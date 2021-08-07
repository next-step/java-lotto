package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private static final LottoMachine lottoMachine = LottoMachine.getInstance();

    @Test
    @DisplayName("수동 로또를 한장 생성한다")
    void manual() {
        Lotto lotto = lottoMachine.manual("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(lotto).isNotNull();
        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("자동 로또를 한장 생성한다")
    void auto() {
        Lotto lotto = lottoMachine.auto();
        Assertions.assertThat(lotto).isNotNull();
        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
