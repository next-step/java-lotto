package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {

    @Test
    void buyOneLotto() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        LotteryMachine lotteryMachine = LotteryMachine.of(1000, shuffleStrategy);

        assertThat(lotteryMachine.lottoes()).usingRecursiveComparison().isEqualTo(
            Lottoes.from(Collections.singletonList(Lotto.from(shuffleStrategy))));
    }

    @Test
    void buyTwoLottoes() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        LotteryMachine lotteryMachine = LotteryMachine.of(2000, shuffleStrategy);

        assertThat(lotteryMachine.lottoes()).usingRecursiveComparison().isEqualTo(
            Lottoes.from(Arrays.asList(Lotto.from(shuffleStrategy), Lotto.from(shuffleStrategy))));
    }

    @Test
    void buyLottoAtWrongPrice() {
        assertThatThrownBy(() -> LotteryMachine.of(1100, new NoShuffleStrategy()))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동로또 수동로또 함께 구입")
    void buyLottoWithManual() {
        NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
        LotteryMachine lotteryMachine = LotteryMachine.of(3000,
            Collections.singletonList(LottoNumbers.from("1,2,3,4,5,6")), shuffleStrategy);
        List<Lotto> lottoes = new ArrayList<>();
        lottoes.add(Lotto.from(shuffleStrategy));
        lottoes.add(Lotto.from(shuffleStrategy));
        lottoes.add(Lotto.from(LottoNumbers.from("1,2,3,4,5,6")));

        assertThat(lotteryMachine.lottoes()).usingRecursiveComparison().isEqualTo(Lottoes.from(lottoes));
    }
}
