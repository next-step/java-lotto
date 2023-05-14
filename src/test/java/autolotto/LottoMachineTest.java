package autolotto;

import autolotto.lotto.Lotto;
import autolotto.lotto.LottoGenerator;
import autolotto.lotto.fixture.FixedNumberShuffler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
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

    @Test
    void 당첨번호가_주어지면_수익률을_소수점_둘째_자리까지_반올림한_값으로_알려준다() {
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator(new FixedNumberShuffler()), 3000);
        BigDecimal expectedProfitRate = BigDecimal.valueOf((double) Winning.THREE.winningMoney() * 3 / 3000).setScale(2);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 21, 22, 23);

        BigDecimal profitRate = lottoMachine.profitRate(winningNumbers);

        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
