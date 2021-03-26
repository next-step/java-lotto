package im.juniq.lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
	private ShuffleStrategy shuffleStrategy;

	public LotteryMachine() {
		shuffleStrategy = new ShuffleStrategyImpl();
	}

	public LotteryMachine(ShuffleStrategy shuffleStrategy) {
		this.shuffleStrategy = shuffleStrategy;
	}

	public List<Lotto> lottoes(int price) {
		if (price % 1000 != 0) {
			throw new RuntimeException("금액은 천원 단위로 입력해주세요.");
		}
		List<Lotto> lottoes = new ArrayList<>();
		for (int i = 0; i < price / 1000; i++) {
			lottoes.add(new Lotto(shuffleStrategy));
		}
		return lottoes;
	}
}
