package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import im.juniq.lotto.domain.LotteryMachine;
import im.juniq.lotto.domain.Lotto;
import im.juniq.lotto.domain.Lottoes;
import im.juniq.lotto.domain.NoShuffleStrategy;

class LotteryMachineTest {
	@Test
	void buyOneLotto() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(1000, shuffleStrategy);

		assertThat(lotteryMachine.lottoes().lotto(0)).isEqualToComparingFieldByField(
			new Lotto(shuffleStrategy));
	}

	@Test
	void buyTwoLottoes() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(2000, shuffleStrategy);

		assertThat(lotteryMachine.lottoes()).usingRecursiveComparison().isEqualTo(
			new Lottoes(new Lotto(shuffleStrategy), new Lotto(shuffleStrategy)));
	}

	@Test
	void buyLottoAtWrongPrice() {
		assertThatThrownBy(() -> new LotteryMachine(1100, new NoShuffleStrategy())).isInstanceOf(RuntimeException.class);
	}
}
