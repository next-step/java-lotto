package im.juniq.lotto.domain;

import java.util.List;

public class LotteryMachine {
	private final Lottoes lottoes;
	private final Price price;

	public LotteryMachine(int price) {
		this(price, new NormalShuffleStrategy());
	}

	public LotteryMachine(int price, ShuffleStrategy shuffleStrategy) {
		this.price = new Price(price);
		lottoes = new Lottoes(this.price.numberOfLottoPurchased() , shuffleStrategy);
	}

	public LotteryMachine(int price, List<String> manualLottoes) {
		this(price, manualLottoes, new NormalShuffleStrategy());
	}

	public LotteryMachine(int price, List<String> manualLottoes, ShuffleStrategy shuffleStrategy) {
		this.price = new Price(price);
		lottoes = new Lottoes(this.price.numberOfLottoPurchased(), shuffleStrategy, manualLottoes);
	}

	public Lottoes lottoes() {
		return lottoes;
	}

	public Price price() {
		return price;
	}
}
