package step2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Lotteries {

	private static final int ADD_MATCH_COUNT = 1;
	private static final int DEFAULT_MATCH_COUNT = 0;
	private static final int DEFAULT_MIN_LENGTH = 0;

	private static HashMap<Rank, Integer> totalMatch = new HashMap<>();
	private WinningLotto winningLotto;
	private List<Lotto> lotteries;
	private int countOfMatchBonus = DEFAULT_MATCH_COUNT;

	private Lotteries(List<Lotto> lotteries, HashMap<Rank, Integer> totalMatch) {
		this.lotteries = lotteries;
		this.totalMatch = totalMatch;
	}

	public static Lotteries of(int totalTicket, LottoFactory lottoFactory) {
		List<Lotto> lotteries = new ArrayList<>();

		for (int ticket = DEFAULT_MIN_LENGTH; ticket < totalTicket; ticket++) {
			lotteries.add(new Lotto(lottoFactory));
		}

		for (Rank rank : Rank.values()) {
			totalMatch.put(rank, DEFAULT_MATCH_COUNT);
		}

		return new Lotteries(lotteries, totalMatch);
	}

	public HashMap<Rank, Integer> isMatch(List<Integer> winNumber, int bonusNumber) {
		winningLotto = WinningLotto.of(winNumber, bonusNumber);

		for (Lotto lotto : lotteries) {
			int countOfMatch = winningLotto.countOfMatch(lotto.getLotto());
			Rank rank = Rank.of(countOfMatch);
			countOfMatchBonus(countOfMatch, lotto.getLotto());

			totalMatch.put(rank, totalMatch.get(rank) + ADD_MATCH_COUNT);
		}
		return totalMatch;
	}

	private void countOfMatchBonus(int countOfMatch, List<Integer> lotto) {
		if (winningLotto.isBonus(countOfMatch, lotto)) {
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