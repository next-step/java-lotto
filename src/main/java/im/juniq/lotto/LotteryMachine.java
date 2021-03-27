package im.juniq.lotto;

import java.util.List;

public class LotteryMachine {
	private static final int LOTTO_PRICE = 1000;

	private ShuffleStrategy shuffleStrategy;
	private Lottoes lottoes;
	private int price;

	public LotteryMachine() {
		shuffleStrategy = new ShuffleStrategyImpl();
	}

	public LotteryMachine(ShuffleStrategy shuffleStrategy) {
		this.shuffleStrategy = shuffleStrategy;
	}

	public Lottoes lottoes(int price) {
		this.price = price;
		checkPrice(price);
		lottoes = new Lottoes(price / LOTTO_PRICE, shuffleStrategy);
		return lottoes;
	}

	private void checkPrice(int price) {
		if (price % LOTTO_PRICE != 0) {
			throw new RuntimeException("금액은 " + LOTTO_PRICE + "원 단위로 입력해주세요.");
		}
	}

	public double yield(List<Integer> winningNumber) {
		double winningAmount = 0;
		winningAmount += Winning.SIX_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(6, winningNumber);
		winningAmount += Winning.FIVE_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(5, winningNumber);
		winningAmount += Winning.FOUR_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(4, winningNumber);
		winningAmount += Winning.THREE_NUMBERS_MATCHED.amount() * lottoes.numberOfLottoesMatched(3, winningNumber);

		return winningAmount / price;
	}
}
