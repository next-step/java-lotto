package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LotteryMachineTest {
	@Test
	void buyOneLotto() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(shuffleStrategy);

		assertThat(lotteryMachine.lottoes(1000).get(0)).isEqualToComparingFieldByField(new Lotto(shuffleStrategy));
	}

	@Test
	void buyTwoLottoes() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(shuffleStrategy);

		assertThat(lotteryMachine.lottoes(2000)).usingRecursiveComparison().isEqualTo(
			Arrays.asList(new Lotto(shuffleStrategy), new Lotto(shuffleStrategy)));
	}
}
