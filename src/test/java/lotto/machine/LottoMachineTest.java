package lotto.machine;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.TestLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    @DisplayName("1~45까지 범위에서 숫자 6개를 가진 Lotto 객체를 만든다.")
    void lottoCreateTest() {
        LottoMachine lottoMachine = new LottoMachine(new TestLottoGenerator(0));

        Lotto lotto = lottoMachine.generate();

        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }
}
