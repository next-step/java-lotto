package im.juniq.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LotteryMachineTest {
	@Test
	void buyOneLotto() {
		LotteryMachine lotteryMachine = new LotteryMachine();

		assertThat(lotteryMachine.lottos(1000).get(0)).isEqualTo(new Lotto());
	}
}
