package im.juniq.lotto;

public class LotteryMachine {
	private Lottoes lottoes;
	private Price price;
	private WinningNumbers winningNumbers;

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

	public void setWinningNumbers(WinningNumbers winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public int numberOfLottoesMatched(int count) {
		return lottoes.numberOfLottoesMatched(count, winningNumbers);
	}

	public double yield() {
		double winningAmount = 0;
		winningAmount += Winning.SIX_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(6, winningNumbers);
		winningAmount += Winning.FIVE_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(5, winningNumbers);
		winningAmount += Winning.FOUR_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(4, winningNumbers);
		winningAmount += Winning.THREE_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(3, winningNumbers);

		return price.yield(winningAmount);
	}
}
