package im.juniq.lotto;

public class LotteryMachine {
	private static final int LOTTO_PRICE = 1000;

	private Lottoes lottoes;
	private int price;
	private WinningNumbers winningNumbers;

	public LotteryMachine(int price) {
		this(price, new ShuffleStrategyImpl());
	}

	public LotteryMachine(int price, ShuffleStrategy shuffleStrategy) {
		this.price = price;
		checkPrice(price);
		lottoes = new Lottoes(price / LOTTO_PRICE, shuffleStrategy);
	}

	public Lottoes lottoes() {
		return lottoes;
	}

	private void checkPrice(int price) {
		if (price % LOTTO_PRICE != 0) {
			throw new RuntimeException("금액은 " + LOTTO_PRICE + "원 단위로 입력해주세요.");
		}
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

		return winningAmount / price;
	}
}
