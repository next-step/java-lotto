package lotto.domain;

import lotto.service.LotteryMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {

    @Test
    @DisplayName("다수의 로또 당첨 결과 확인")
    void checkLottos() {
        Lotto lotto1 = new Lotto(() -> Numbers.builder().range(1, 7).build());
        Lotto lotto2 = new Lotto(() -> Numbers.builder().range(2, 8).build());
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));
        Numbers winningNumbers = Numbers.builder().range(1, 7).build();

        LotteryMachine lotteryMachine = new LotteryMachine(lottos, winningNumbers);
        WinningRanks winningRanks = lotteryMachine.getWinningRanks();

        WinningRanks expectedWinningRanks = new WinningRanks(Arrays.asList(WinningRank.FIRST, WinningRank.SECOND));
        assertThat(winningRanks).isEqualTo(expectedWinningRanks);
    }
}
