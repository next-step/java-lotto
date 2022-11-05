package step3.model;

import java.util.List;
import java.util.Map;

public class LottoChecker {

	private final WinnerLotto winnerLotto;

	public LottoChecker(WinnerLotto winnerLotto) {
		this.winnerLotto = winnerLotto;
	}

	public static int rank(final int matchCnt, final boolean matchBonus) {
		if (matchCnt == 6) return 1;
		if (matchCnt == 5 && matchBonus) return 2;
		if (matchCnt > 2) {
			return 6 - matchCnt + 2;
		}
		return 0;
	}

	public static double getEarningRate(Map<Integer, Integer> hitCntMap, Money money) {
		int prizeMoneySum = hitCntMap.keySet().stream()
				.mapToInt(rank -> rank)
				.map(rank -> Awards.getPrize(rank, hitCntMap.get(rank)))
				.sum();
		return (double) prizeMoneySum / money.getMoney();
	}

	public int match(Lotto lotto) {
		List<Integer> numberList = lotto.getNumberList();
		return rank(countHit(numberList), checkBonusHit(numberList));
	}

	private int countHit(List<Integer> lottoList) {
		return (int) winnerLotto.getWinningNumber().stream()
				.mapToInt(hitNumber -> hitNumber)
				.filter(lottoList::contains)
				.count();
	}

	private boolean checkBonusHit(List<Integer> lottoList) {
		return lottoList.contains(winnerLotto.getBonusNumber());
	}
}
