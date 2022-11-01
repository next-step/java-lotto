package step2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Lotteries {
	private static final int DEFAULT_MATCH_COUNT = 0;
	private static final int DEFAULT_MIN_LENGTH = 0;

	private HashMap<Rank, Integer> totalMatch;
	private WinningLotto winningLotto;
	private List<Lotto> lotteries;


	private Lotteries(List<Lotto> lotteries, HashMap<Rank, Integer> totalMatch) {
		this.lotteries = lotteries;
		this.totalMatch = totalMatch;
	}

	public static Lotteries of(List<Lotto> handLotto,int autoTicket, LottoFactory lottoFactory) {
		HashMap<Rank,Integer> totalMatch = new HashMap<>();

		List<Lotto> lotteries = new ArrayList<>();
		lotteries.addAll(handLotto);
		for (int ticket = DEFAULT_MIN_LENGTH; ticket < autoTicket; ticket++) {
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
			Rank rank = Rank.of(countOfMatch, winningLotto.isBonus(lotto.getLotto()));

			totalMatch.put(rank, totalMatch.get(rank) + 1);
		}

		return totalMatch;
	}

	public Lotto showLotteries(int i) {
		return lotteries.get(i);
	}

}