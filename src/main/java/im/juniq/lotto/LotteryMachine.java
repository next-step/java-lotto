package im.juniq.lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
	private static final int LOTTO_PRICE = 1000;

	private ShuffleStrategy shuffleStrategy;

	public LotteryMachine() {
		shuffleStrategy = new ShuffleStrategyImpl();
	}

	public LotteryMachine(ShuffleStrategy shuffleStrategy) {
		this.shuffleStrategy = shuffleStrategy;
	}

	public List<Lotto> lottoes(int price) {
		checkPrice(price);
		return makeLotto(price / LOTTO_PRICE);
	}

	private List<Lotto> makeLotto(int numberOfCreated) {
		List<Lotto> lottoes = new ArrayList<>();
		for (int i = 0; i < numberOfCreated; i++) {
			lottoes.add(new Lotto(shuffleStrategy));
		}
		return lottoes;
	}

	private void checkPrice(int price) {
		if (price % LOTTO_PRICE != 0) {
			throw new RuntimeException("금액은 " + LOTTO_PRICE + "원 단위로 입력해주세요.");
		}
	}
}
