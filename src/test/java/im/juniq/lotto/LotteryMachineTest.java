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

	@Test
	void countMatchedLottoes() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(shuffleStrategy);

		Lottoes lottoes = lotteryMachine.lottoes(14000);

		assertThat(lottoes.numberOfLottoesMatched(3, Arrays.asList(1, 2, 3, 7, 8, 9))).isEqualTo(14);
		assertThat(lottoes.numberOfLottoesMatched(4, Arrays.asList(1, 2, 3, 4, 8, 9))).isEqualTo(14);
	}

	@Test
	void calculateYield() {
		LotteryMachine lotteryMachine = new LotteryMachine(new NoShuffleStrategy());
		lotteryMachine.lottoes(1000);

		assertThat(lotteryMachine.yield(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(2000000);
		assertThat(lotteryMachine.yield(Arrays.asList(1, 2, 3, 4, 5, 7))).isEqualTo(1500);
		assertThat(lotteryMachine.yield(Arrays.asList(1, 2, 3, 4, 7, 8))).isEqualTo(50);
		assertThat(lotteryMachine.yield(Arrays.asList(1, 2, 3, 7, 8, 9))).isEqualTo(5);
	}
}
