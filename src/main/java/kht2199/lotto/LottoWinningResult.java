package kht2199.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kht2199.lotto.data.Lotto;
import kht2199.lotto.data.LottoList;

/**
 *
 * @author heetaek.kim
 */
public class LottoWinningResult {

	private final Lotto winningNumber;

	/**
	 * 일치갯수, 일치갯수에 대한 상금의 총합을 기록한다.
	 */
	private final Map<Integer, Integer> matchedPrizeMap;

	private LottoRule rule;

	public LottoWinningResult(Lotto winningNumber) {
		this.winningNumber = winningNumber;
		this.matchedPrizeMap = new HashMap<>();
		initMatchedPrizeMap();
	}

	/**
	 * 당첨 갯수, 당첨 금액 설정
	 */
	public void updateLottoWinningNumbers(LottoRule rule, LottoList list) {
		this.rule = rule;
		initMatchedPrizeMap();
		for (Lotto lotto : list.getList()) {
			int matched = calculateMatched(winningNumber, lotto);
			Integer totalPrize = matchedPrizeMap.get(matched);
			matchedPrizeMap.put(matched, totalPrize + rule.prize(matched));
		}
	}

	/**
	 * @param winningNumber 당첨번호.
	 * @param lotto 비교대상 로또.
	 * @return 결과정보.
	 */
	protected int calculateMatched(Lotto winningNumber, Lotto lotto) {
		List<Integer> winningNumbers = winningNumber.getNumbers();
		List<Integer> numbers = lotto.getNumbers();
		int matched = 0;
		for (Integer number : numbers) {
			matched += winningNumbers.contains(number) ? 1 : 0;
		}
		return matched;
	}

	public int countMatched(int matched) {
		Integer totalMatchedPrize = matchedPrizeMap.get(matched);
		int prize = rule.prize(matched);
		if (prize == 0) {
			return 0;
		}
		return totalMatchedPrize / prize;
	}

	public int totalPrize() {
		int sum = 0;
		for (Integer value : matchedPrizeMap.values()) {
			sum += value;
		}
		return sum;
	}

	/**
	 * 수익률을 계산한다.
	 *
	 * @param assets 사용한 자산.
	 * @return 수익률 범위 0~1
	 */
	public float rate(int assets) {
		return (float) totalPrize() / assets;
	}

	private void initMatchedPrizeMap() {
		for (int i = 0; i <= 6; i++) {
			matchedPrizeMap.put(i, 0);
		}
	}
}
