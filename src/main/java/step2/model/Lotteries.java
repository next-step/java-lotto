package step2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Lotteries {

	private static final int ADD_MATCH_COUNT = 1;
	private static final int DEFAULT_MATCH_COUNT = 0;
	private static final int DEFAULT_MIN_LENGTH = 0;
	private static final int DEFAULT_MAX_LENGTH = 6;
	private static HashMap<Integer, Integer> totalMatch = new HashMap<>();
	private static WinningLotto winningLotto;

	private List<Lotto> lotteries;
	private int countOfMatchBonus = 0;

	private Lotteries(List<Lotto> lotteries, HashMap<Integer, Integer> totalMatch) {
		this.lotteries = lotteries;
		this.totalMatch = totalMatch;
	}

	public static Lotteries of(int totalTicket, LottoFactory lottoFactory) {
		List<Lotto> lotteries = new ArrayList<>();

		for (int ticket = DEFAULT_MIN_LENGTH; ticket < totalTicket; ticket++) {
			lotteries.add(new Lotto(lottoFactory));
		}

		for (int matchNumber = DEFAULT_MIN_LENGTH; matchNumber <= DEFAULT_MAX_LENGTH; matchNumber++) {
			totalMatch.put(matchNumber, DEFAULT_MATCH_COUNT);
		}

		return new Lotteries(lotteries, totalMatch);
	}

	public HashMap<Integer, Integer> isMatch(List<Integer> winNumber, int bonusNumber) {
		winningLotto = WinningLotto.of(winNumber, bonusNumber);

		for (Lotto lotto : lotteries) {
			int countOfMatch = winningLotto.countOfMatch(lotto.getLotto());
			countOfMatchBonus(countOfMatch, lotto.getLotto());

			totalMatch.put(countOfMatch, totalMatch.get(countOfMatch) + ADD_MATCH_COUNT);
		}
		return totalMatch;
	}

	private void countOfMatchBonus(int countLottoMatch, List<Integer> lotto) {
		if (winningLotto.isBonus(countLottoMatch, lotto)) {
			countOfMatchBonus += ADD_MATCH_COUNT;
		}
	}

	public Lotto showLotteries(int i) {
		return lotteries.get(i);
	}

	public int countOfMatchBonus() {
		return countOfMatchBonus;
	}

}