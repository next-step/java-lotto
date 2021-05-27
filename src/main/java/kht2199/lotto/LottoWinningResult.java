package kht2199.lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kht2199.lotto.data.Lotto;
import kht2199.lotto.data.LottoList;
import kht2199.lotto.exception.LottoNumberDuplicatedException;
import kht2199.lotto.exception.LottoNumberNotInitiatedException;
import kht2199.lotto.exception.LottoNumberSizeInvalidException;

/**
 *
 * @author heetaek.kim
 */
public class LottoWinningResult {

	/**
	 * 일치갯수, 일치갯수에 대한 상금의 총합을 기록한다.
	 */
	private final Map<Integer, Integer> matchedPrizeMap;

	private List<Integer> winningNumber;

	private int bonusNumber;

	private LottoRule rule;

	public LottoWinningResult() {
		this.matchedPrizeMap = new HashMap<>();
		initMatchedPrizeMap();
	}

	/**
	 * 당첨 갯수, 당첨 금액 설정
	 */
	public void updateLottoWinningNumbers(LottoRule rule, LottoList list) {
		// TODO RuntimeException을 DomainException으로 변경.
		if (winningNumber == null) {
			throw new RuntimeException("당첨번호가 설정되어 있지 않습니다.");
		}
		if (bonusNumber == 0) {
			throw new RuntimeException("보너스 번호가 설정되어 있지 않습니다.");
		}
		this.rule = rule;
		initMatchedPrizeMap();
		for (Lotto lotto : list.getList()) {
			int matched = calculateMatched(lotto);
			Integer totalPrize = matchedPrizeMap.get(matched);
			matchedPrizeMap.put(matched, totalPrize + rule.prize(matched));
		}
	}

	/**
	 * @param lotto 비교대상 로또.
	 * @return 결과정보.
	 */
	protected int calculateMatched(Lotto lotto) {
		List<Integer> numbers = lotto.getNumbers();
		int matched = 0;
		for (Integer number : numbers) {
			matched += winningNumber.contains(number) ? 1 : 0;
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

	public void setBonusNumber(int bonusNumber)
			throws LottoNumberDuplicatedException, LottoNumberNotInitiatedException {
		if (winningNumber == null) {
			throw new LottoNumberNotInitiatedException();
		}
		if (winningNumber.contains(bonusNumber)) {
			throw new LottoNumberDuplicatedException();
		}
		this.bonusNumber = bonusNumber;
	}

	public void setWinningNumbers(List<Integer> numbers) throws LottoNumberSizeInvalidException {
		if (numbers == null || numbers.size() != 6) {
			throw new LottoNumberSizeInvalidException();
		}
		this.winningNumber = Collections.unmodifiableList(numbers);
	}

	private void initMatchedPrizeMap() {
		for (int i = 0; i <= 6; i++) {
			matchedPrizeMap.put(i, 0);
		}
	}

}
