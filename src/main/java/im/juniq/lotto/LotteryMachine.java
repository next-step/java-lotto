package im.juniq.lotto;

public class LotteryMachine {
	private Lottoes lottoes;
	private Price price;

	public LotteryMachine(int price) {
		this(price, new ShuffleStrategyImpl());
	}

	public LotteryMachine(int price, ShuffleStrategy shuffleStrategy) {
		this.price = new Price(price);
		lottoes = new Lottoes(this.price.numberOfLottoPurchased() , shuffleStrategy);
	}

	public Lottoes lottoes() {
		return lottoes;
	}

	public Price price() {
		return price;
	}
}
