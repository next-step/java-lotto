package lotto.domain;

import lotto.domain.repository.*;
import lotto.domain.service.LotteryMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {
    private LotteryMachine lotteryMachine;

    @BeforeEach
    void setUp() {
        Numbers numbers = Numbers.builder().range(1, 7).build();
        lotteryMachine = new LotteryMachine(numbers);
    }

    @Test
    @DisplayName("다수의 로또 당첨 결과 확인")
    void checkLottos() {
        Lotto lotto1 = new Lotto(() -> Numbers.builder().range(1, 7).build());
        Lotto lotto2 = new Lotto(() -> Numbers.builder().range(2, 8).build());
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        WinningRanks winningRanks = lotteryMachine.checkLottos(lottos);

        WinningRanks expectedWinningRanks = new WinningRanks(Arrays.asList(WinningRank.FIRST, WinningRank.SECOND));
        assertThat(winningRanks).isEqualTo(expectedWinningRanks);
    }
}
