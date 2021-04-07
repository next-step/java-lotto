package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {

    @Test
    void buyOneLotto() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        LotteryMachine lotteryMachine = LotteryMachine.withPrice(1000, shuffleStrategy);

        assertThat(lotteryMachine.lottoes().lotto(0)).usingRecursiveComparison().isEqualTo(
            new Lotto(shuffleStrategy));
    }

    @Test
    void buyTwoLottoes() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        LotteryMachine lotteryMachine = LotteryMachine.withPrice(2000, shuffleStrategy);

        assertThat(lotteryMachine.lottoes()).usingRecursiveComparison().isEqualTo(
            new Lottoes(new Lotto(shuffleStrategy), new Lotto(shuffleStrategy)));
    }

    @Test
    void buyLottoAtWrongPrice() {
        assertThatThrownBy(() -> LotteryMachine.withPrice(1100, new NoShuffleStrategy()))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동로또 수동로또 함께 구입")
    void buyLottoWithManual() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        LotteryMachine lotteryMachine = LotteryMachine.withManualNumbers(3000,
            Collections.singletonList(new LottoNumbers("1,2,3,4,5,6")), shuffleStrategy);
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottoes.add(new Lotto(shuffleStrategy));
        }

        assertThat(lotteryMachine.lottoes()).usingRecursiveComparison().isEqualTo(new Lottoes(lottoes));
    }
}
