package step2.model;

import static step2.model.Lotto.handLotto;
import static step2.model.Lotto.randomLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lotteries {

	private static final int DEFAULT_MATCH_COUNT = 0;
	private static final int DEFAULT_MIN_LENGTH = 0;

	private HashMap<Rank, Integer> totalMatch;
	private List<Lotto> lotteries;


	private Lotteries(List<Lotto> lotteries, HashMap<Rank, Integer> totalMatch) {
		this.lotteries = lotteries;
		this.totalMatch = totalMatch;
	}

	public static Lotteries of(List<Integer> handLotto, int autoTicket) {
		HashMap<Rank, Integer> totalMatch = new HashMap<>();
		List<Lotto> lotteries = new ArrayList<>();

		lotteries.add(handLotto(handLotto));

		for (int ticket = DEFAULT_MIN_LENGTH; ticket < autoTicket; ticket++) {
			lotteries.add(randomLotto());
		}

		for (Rank rank : Rank.values()) {
			totalMatch.put(rank, DEFAULT_MATCH_COUNT);
		}

		return new Lotteries(lotteries, totalMatch);
	}

	public HashMap<Rank, Integer> isMatch(List<Integer> winNumber, int bonusNumber) {
		WinningLotto winningLotto = WinningLotto.of(winNumber, bonusNumber);

		for (Lotto lotto : lotteries) {
			int countOfMatch = winningLotto.countOfMatch(lotto.getLotto());
			Rank rank = Rank.of(countOfMatch, winningLotto.isBonus(lotto.getLotto()));

			totalMatch.put(rank, totalMatch.get(rank) + 1);
		}

		return totalMatch;
	}

	public Lotto showLotteries(int i) {
		return lotteries.get(i);
	}

}