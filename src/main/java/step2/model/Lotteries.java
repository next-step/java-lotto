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

	private static HashMap<Integer, Integer> totalMatchInfo = new HashMap<>();
	private static WinningLotto winningLotto;
	private List<Lotto> lotteries;
	private int countOfMatchBonus = 0;

	private Lotteries(List<Lotto> lotteries, HashMap<Integer, Integer> totalMatchInfo) {
		this.lotteries = lotteries;
		this.totalMatchInfo = totalMatchInfo;
	}

	public static Lotteries of(int totalTicket, LottoFactory lottoFactory) {
		List<Lotto> lotteries = new ArrayList<>();

		for (int i = DEFAULT_MIN_LENGTH; i < totalTicket; i++) {
			lotteries.add(new Lotto(lottoFactory));
		}

		for (int i = DEFAULT_MIN_LENGTH; i < DEFAULT_MAX_LENGTH; i++) {
			totalMatchInfo.put(i, DEFAULT_MATCH_COUNT);
		}

		return new Lotteries(lotteries, totalMatchInfo);
	}

	public HashMap<Integer, Integer> isMatch(List<Integer> winNumList, int bonusNumber) {
		winningLotto = WinningLotto.of(winNumList, bonusNumber);

		for (Lotto lotto : lotteries) {
			int countOfMatch = winningLotto.countOfMatch(lotto.getLotto());
			isBonus(countOfMatch, lotto.getLotto());

			totalMatchInfo.put(countOfMatch, totalMatchInfo.get(countOfMatch) + ADD_MATCH_COUNT);
		}
		return totalMatchInfo;
	}

	private void isBonus(int countLottoMatch, List<Integer> lotto) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lotteries lotteries = (Lotteries) o;
		return Objects.equals(lotteries, lotteries.lotteries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotteries);
	}


}