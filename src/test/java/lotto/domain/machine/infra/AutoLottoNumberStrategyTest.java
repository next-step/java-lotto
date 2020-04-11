package lotto.domain.machine.infra;

import lotto.domain.lotto.Lotteries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberStrategyTest {

    @DisplayName("자동 생성할 개수를 입력하면 수에 맞춰 자동 번호 로또가 생성된다")
    @Test
    public void autoLottoNumberGetTest() {
        AutoLottoNumberStrategy oneStrategy = new AutoLottoNumberStrategy(1);
        AutoLottoNumberStrategy anotherStrategy = new AutoLottoNumberStrategy(1);

        Lotteries oneLotteries = oneStrategy.get();
        Lotteries anotherLotteries = anotherStrategy.get();

        assertThat(oneLotteries.getLotteries()).hasSize(1);
        assertThat(anotherLotteries.getLotteries()).hasSize(1);

        assertThat(oneLotteries).isNotEqualTo(anotherLotteries);
    }

}
