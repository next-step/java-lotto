package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LotteryMachineTest {
	@Test
	void buyOneLotto() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(shuffleStrategy);

		assertThat(lotteryMachine.lottoes(1000).lotto(0)).isEqualToComparingFieldByField(
			new Lotto(shuffleStrategy));
	}

	@Test
	void buyTwoLottoes() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(shuffleStrategy);

		assertThat(lotteryMachine.lottoes(2000)).usingRecursiveComparison().isEqualTo(
			new Lottoes(new Lotto(shuffleStrategy), new Lotto(shuffleStrategy)));
	}

	@Test
	void buyLottoAtWrongPrice() {
		LotteryMachine lotteryMachine = new LotteryMachine(new NoShuffleStrategy());

		assertThatThrownBy(() -> lotteryMachine.lottoes(1100)).isInstanceOf(RuntimeException.class);
	}
}
