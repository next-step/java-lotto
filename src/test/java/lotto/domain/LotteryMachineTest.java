package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.Utils.makeRangeNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {
    private LotteryMachine lotteryMachine;

    @BeforeEach
    void setUp() {
        lotteryMachine = new LotteryMachine(makeRangeNumbers(1, 7));
    }

    @Test
    @DisplayName("다수의 로또 당첨 결과 확인")
    void checkLottos() {
        Lotto lotto1 = new Lotto(() -> makeRangeNumbers(1, 7));
        Lotto lotto2 = new Lotto(() -> makeRangeNumbers(2, 8));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        WinningRanks winningRanks = lotteryMachine.checkLottos(lottos);

        WinningRanks expectedWinningRanks = new WinningRanks(Arrays.asList(WinningRank.FIRST, WinningRank.SECOND));
        assertThat(winningRanks).isEqualTo(expectedWinningRanks);
    }
}
