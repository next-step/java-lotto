package im.juniq.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LotteryMachine {
	private ShuffleStrategy shuffleStrategy;

	public LotteryMachine() {
		shuffleStrategy = new ShuffleStrategyImpl();
	}

	public LotteryMachine(ShuffleStrategy shuffleStrategy) {
		this.shuffleStrategy = shuffleStrategy;
	}

	public List<Lotto> lottos(int price) {
		return Collections.singletonList(new Lotto(shuffleStrategy));
	}
}
