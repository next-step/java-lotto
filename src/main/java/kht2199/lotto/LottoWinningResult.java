package kht2199.lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author heetaek.kim
 */
public class LottoWinningResult {

	private final Lotto winningNumber;

	private final Map<Lotto, LottoResult> results = new HashMap<>();

	public LottoWinningResult(Lotto winningNumber) {
		this.winningNumber = winningNumber;
	}

	/**
	 * 당첨 갯수, 당첨 금액 설정
	 */
	public void updateLottoWinningNumbers(LottoRule rule, LottoList list) {
		results.clear();
		for (Lotto lotto : list.getList()) {
			results.put(lotto, calculate(rule, winningNumber, lotto));
		}
	}

	/**
	 *
	 *
	 * @param rule 로또 규칙.
	 * @param winningNumber 당첨번호.
	 * @param lotto 비교대상 로또.
	 * @return 결과정보.
	 */
	protected LottoResult calculate(LottoRule rule, Lotto winningNumber, Lotto lotto) {
		List<Integer> winningNumbers = winningNumber.getNumbers();
		List<Integer> numbers = lotto.getNumbers();
		int matched = 0;
		for (Integer number : numbers) {
			matched += ifContainsThenOneElseZero(winningNumbers, number);
		}
		return new LottoResult(matched, rule.prize(matched));
	}

	public Map<Lotto, LottoResult> getWinningNumber() {
		return Collections.unmodifiableMap(results);
	}

	/**
	 * 2-depth 를 지키기 위해 만들어진 메서드.
	 */
	protected int ifContainsThenOneElseZero(List<Integer> list, Integer number) {
		return list.contains(number) ? 1 : 0;
	}
}
