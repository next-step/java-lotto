package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lotto {

	private static final int LOTTO_PRICE = 1000;
	private List<Integer>[] lotto;
	private List<Integer> winningNumber;
	private final LottoResult lottoResult;
	private final RandomGenerator random;

	public Lotto(String pay, RandomGenerator random, LottoResult lottoResult) {
		this.random = random;
		this.lottoResult = lottoResult;

		int numberOfLotto = Integer.parseInt(pay) / LOTTO_PRICE;
		lotto = new List[numberOfLotto];

		buyLotto();
	}

	public int numberOfLotto() {
		return lotto.length;
	}

	private void buyLotto() {
		int numberOfLotto = numberOfLotto();
		for (int i = 0; i < numberOfLotto; i++) {
			lotto[i] = new ArrayList<>();
			lotto[i].addAll(this.random.generate());
		}
	}

	public void winningNumber(String numbers) {
		String[] winningNumbers = numbers.split(", ");

		this.winningNumber = new ArrayList<>();
		for (String number : winningNumbers) {
			this.winningNumber.add(Integer.parseInt(number));
		}
	}

	public void drawLotto() {
		for (List<Integer> random : lotto) {
			lottoResult.addRank(LottoRank.match(this.winningNumber, random));
		}
		lottoResult.calculateTotalWinningMoney();
		lottoResult.calculateReturnRate(LOTTO_PRICE * this.lotto.length);
	}

	public Map<LottoRank, Integer> totalWinningStatistics() {
		return this.lottoResult.totalWinningStatistics();
	}

	public double returnRate() {
		return this.lottoResult.returnRate();
	}

	public List<Integer>[] lotto() {
		return lotto;
	}

}
