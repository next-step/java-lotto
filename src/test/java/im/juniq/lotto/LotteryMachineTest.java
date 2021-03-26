package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LotteryMachineTest {
	@Test
	void buyOneLotto() {
		NoShuffleStrategy shuffleStrategy = new NoShuffleStrategy();
		LotteryMachine lotteryMachine = new LotteryMachine(shuffleStrategy);

		assertThat(lotteryMachine.lottos(1000).get(0)).isEqualToComparingFieldByField(new Lotto(shuffleStrategy));
	}
}
