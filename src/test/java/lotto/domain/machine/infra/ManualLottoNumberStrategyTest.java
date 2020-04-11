package lotto.domain.machine.infra;

import lotto.domain.lotto.Lotteries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoNumberStrategyTest {

    @DisplayName("수동 번호를 입력받아 수동 로또로 생성할 수 있다")
    @Test
    public void manualLottoNumberGetTest() {

        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotteries manualLotteries = Lotteries.of(Arrays.asList(lottoNumbers1, lottoNumbers2));
        ManualLottoNumberStrategy manualStrategy =
                new ManualLottoNumberStrategy(manualLotteries);

        Lotteries lotteries = manualStrategy.get();

        assertThat(lotteries).isEqualTo(manualLotteries);
    }

}
