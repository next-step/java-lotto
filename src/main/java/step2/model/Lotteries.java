package step2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Lotteries {

	private static final int MATCH = 1;
	private List<Lotto> lotteries;

	private static HashMap<Integer, Integer> matchTotalMap = new HashMap<>();


	private Lotteries(List<Lotto> lotteries, HashMap<Integer, Integer> matchTotalMap) {
		this.lotteries = lotteries;
		this.matchTotalMap = matchTotalMap;
	}

	public static Lotteries of(int totalTicket, LottoFactory lottoFactory) {

		List<Lotto> lotteries = new ArrayList<>();

		for (int i = 0; i < totalTicket; i++) {
			lotteries.add(new Lotto(lottoFactory));

		}

		for (int i = 0; i < 7; i++) {
			matchTotalMap.put(i, 0);
		}

		return new Lotteries(lotteries, matchTotalMap);
	}

	public HashMap<Integer, Integer> isMatch(List<Integer> winNumList) {

		for (Lotto lotto : lotteries) {
			LottoMatcher lottoMatcher = new LottoMatcher(winNumList);

			int countLottoMatch = lottoMatcher.countMatch(lotto);
			matchTotalMap.put(countLottoMatch, matchTotalMap.get(countLottoMatch) + MATCH);
		}

		return matchTotalMap;
	}

	public Lotto showLotteries(int i) {
		return lotteries.get(i);
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