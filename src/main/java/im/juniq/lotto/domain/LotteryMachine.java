package im.juniq.lotto.domain;

import java.util.List;

public class LotteryMachine {
	private final Lottoes lottoes;
	private final Price price;

	public LotteryMachine(int price, ShuffleStrategy shuffleStrategy) {
		this(new Price(price), shuffleStrategy);
	}

	public LotteryMachine(Price price, ShuffleStrategy shuffleStrategy) {
		this.price = price;
		lottoes = new Lottoes(this.price.numberOfLottoPurchased() , shuffleStrategy);
	}

	public LotteryMachine(Price price, List<LottoNumbers> manualLottoes) {
		this(price, manualLottoes, new NormalShuffleStrategy());
	}

	public LotteryMachine(Price price, List<LottoNumbers> manualLottoes, ShuffleStrategy shuffleStrategy) {
		this.price = price;
		lottoes = new Lottoes(this.price.numberOfLottoPurchased(), shuffleStrategy, manualLottoes);
	}

	public Lottoes lottoes() {
		return lottoes;
	}

	public Price price() {
		return price;
	}
}
