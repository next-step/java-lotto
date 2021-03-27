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

	@Test
	void countMatchedLottoes() {
		LotteryMachine lotteryMachine = new LotteryMachine(14000, new NoShuffleStrategy());
		Lottoes lottoes = lotteryMachine.lottoes();

		assertThat(lottoes.numberOfLottoesMatched(3, new WinningNumbers(1, 2, 3, 7, 8, 9))).isEqualTo(14);
		assertThat(lottoes.numberOfLottoesMatched(4, new WinningNumbers(1, 2, 3, 4, 8, 9))).isEqualTo(14);
	}

	@Test
	void calculateYield() {
		LotteryMachine lotteryMachine = new LotteryMachine(1000, new NoShuffleStrategy());

		lotteryMachine.setWinningNumbers(new WinningNumbers(1, 2, 3, 4, 5, 6));
		assertThat(lotteryMachine.yield()).isEqualTo(2000000);
		lotteryMachine.setWinningNumbers(new WinningNumbers(1, 2, 3, 4, 5, 7));
		assertThat(lotteryMachine.yield()).isEqualTo(15000);
		lotteryMachine.setWinningNumbers(new WinningNumbers(1, 2, 3, 4, 7, 8));
		assertThat(lotteryMachine.yield()).isEqualTo(50);
		lotteryMachine.setWinningNumbers(new WinningNumbers(1, 2, 3, 7, 8, 9));
		assertThat(lotteryMachine.yield()).isEqualTo(5);
	}
}
