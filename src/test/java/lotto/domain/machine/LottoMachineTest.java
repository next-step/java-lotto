package lotto.domain.machine;

import lotto.domain.lotto.Lotteries;
import lotto.domain.machine.infra.AutoLottoNumberStrategy;
import lotto.domain.machine.infra.ManualLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("로또 기계는 로또를 인자로 전달하는 전략에 따라 구매할 수 있다. - 수동")
    @Test
    public void manualLottoBuy() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotteries manualLotteries = Lotteries.of(Arrays.asList(lottoNumbers1, lottoNumbers2));

        LottoMachine lottoMachine = new LottoMachine();
        Lotteries boughtLotteries = lottoMachine.buy(new ManualLottoNumberStrategy(manualLotteries));

        assertThat(manualLotteries).isEqualTo(boughtLotteries);
    }

    @DisplayName("로또 기계는 로또를 인자로 전달하는 전략에 따라 구매할 수 있다. - 자동")
    @Test
    public void autoLottoBuy() {
        LottoMachine lottoMachine = new LottoMachine();
        Lotteries autoLotteries = lottoMachine.buy(new AutoLottoNumberStrategy(1));
        Lotteries anotherAutoLotteries = lottoMachine.buy(new AutoLottoNumberStrategy(1));

        assertThat(autoLotteries).isNotEqualTo(anotherAutoLotteries);
    }

}
