package autolotto;

import autolotto.lotto.Lotto;
import autolotto.lotto.LottoGenerator;
import autolotto.lotto.fixture.FixedNumberShuffler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoMachineTest {

    @Test
    void 금액에_따라_로또를_생성해_갖고_있다() {
        int inputMoney = 2000;

        LottoMachine lottoMachine =
                new LottoMachine(new LottoGenerator(new FixedNumberShuffler()), inputMoney);

        List<Lotto> createdLotteries = lottoMachine.lotteries();

        Assertions.assertThat(createdLotteries).hasSize(inputMoney / 1000);
    }
}
