package im.juniq.lotto;

public class LotteryMachine {
	private static final int LOTTO_PRICE = 1000;

	private ShuffleStrategy shuffleStrategy;

	public LotteryMachine() {
		shuffleStrategy = new ShuffleStrategyImpl();
	}

	public LotteryMachine(ShuffleStrategy shuffleStrategy) {
		this.shuffleStrategy = shuffleStrategy;
	}

	public Lottoes lottoes(int price) {
		checkPrice(price);
		return new Lottoes(price / LOTTO_PRICE, shuffleStrategy);
	}

	private void checkPrice(int price) {
		if (price % LOTTO_PRICE != 0) {
			throw new RuntimeException("금액은 " + LOTTO_PRICE + "원 단위로 입력해주세요.");
		}
	}
}
