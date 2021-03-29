package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

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
