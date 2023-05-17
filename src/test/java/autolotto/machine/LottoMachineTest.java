package autolotto.machine;

import autolotto.machine.lotto.Lotto;
import autolotto.machine.lotto.LottoGenerator;
import autolotto.machine.lotto.fixture.FixedNumberShuffler;
import autolotto.machine.winning.Winning;
import autolotto.machine.winning.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoMachineTest {
    private final BonusNumber bonusAnyLottoNotContaining = new BonusNumber(11);

    @Test
    void 금액에_따라_로또를_생성해_갖고_있다() {
        int inputMoney = 2000;

        LottoMachine lottoMachine =
                new LottoMachine(new LottoGenerator(new FixedNumberShuffler()), inputMoney);

        List<Lotto> createdLotteries = lottoMachine.lotteries();

        Assertions.assertThat(createdLotteries).hasSize(inputMoney / 1000);
    }

    @Test
    void 머신이_생성한_로또의_개수를_알려준다() {
        int inputMoney = 2000;

        LottoMachine lottoMachine =
                new LottoMachine(new LottoGenerator(new FixedNumberShuffler()), inputMoney);

        Assertions.assertThat(lottoMachine.lottoCount()).isEqualTo(inputMoney / 1000);
    }

    @Test
    void 당첨번호가_주어지면_수익률을_소수점_둘째_자리까지_반올림한_값으로_알려준다() {
        LottoMachine lottoMachine = new LottoMachine(new LottoGenerator(new FixedNumberShuffler()), 3000);
        BigDecimal expectedProfitRate = BigDecimal.valueOf((double) Winning.THREE.winningMoney() * 3 / 3000).setScale(2);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 21, 22, 23));

        BigDecimal profitRate = lottoMachine.profitRate(winningNumbers, bonusAnyLottoNotContaining);

        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @Test
    void 당첨번호가_주어지면_일치_개수별_로또_개수를_알려준다() {
        LottoMachine lottoMachineWithSameThreeLotto = new LottoMachine(new LottoGenerator(new FixedNumberShuffler()), 3000);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 21, 22, 23));

        Map<Winning, Integer> numberOfEachMatchingCount = lottoMachineWithSameThreeLotto.winningState(winningNumbers);

        Assertions.assertThat(numberOfEachMatchingCount.get(Winning.THREE)).isEqualTo(3);
    }
}
