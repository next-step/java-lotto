package kht2199.lotto;

import java.util.List;

import kht2199.Rank;
import kht2199.lotto.data.Lotto;
import kht2199.lotto.data.LottoList;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.LottoWinningNumberNotInitiatedException;
import kht2199.lotto.exception.lotto.LottoNumberException;
import kht2199.lotto.exception.lotto.LottoNumberLengthException;

/**
 * @author heetaek.kim
 */
public class LottoWinningResult {

	private final LottoPrizeResult lottoPrizeResult;

	private Lotto winningNumber;

	private int bonusNumber;

	public LottoWinningResult() {
		this.lottoPrizeResult = new LottoPrizeResult();
	}

	/**
	 * 당첨 갯수, 당첨 금액 설정
	 */
	public void updateLottoWinningNumbers(LottoList list) {
		// TODO RuntimeException을 DomainException으로 변경.
		if (winningNumber == null) {
			throw new RuntimeException("당첨번호가 설정되어 있지 않습니다.");
		}
		if (bonusNumber == 0) {
			throw new RuntimeException("보너스 번호가 설정되어 있지 않습니다.");
		}
		lottoPrizeResult.reset();
		for (Lotto lotto : list.getList()) {
			Rank rank = calculateMatched(lotto);
			lottoPrizeResult.addWinningMoney(rank);
		}
	}

	/**
	 * @param lotto 비교대상 로또.
	 * @return 결과정보.
	 */
	protected Rank calculateMatched(Lotto lotto) {
		List<Integer> numbers = lotto.getNumbers();
		int matched = 0;
		for (Integer number : numbers) {
			matched += winningNumber.contains(number) ? 1 : 0;
		}
		if (matched == 5 && numbers.contains(bonusNumber)) {
			return Rank.SECOND;
		}
		return Rank.valueOf(matched, false);
	}

	public int totalPrize() {
		return lottoPrizeResult.totalPrize();
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
			throws LottoBonusNumberDuplicatedException, LottoWinningNumberNotInitiatedException {
		if (winningNumber == null) {
			throw new LottoWinningNumberNotInitiatedException();
		}
		if (winningNumber.contains(bonusNumber)) {
			throw new LottoBonusNumberDuplicatedException();
		}
		this.bonusNumber = bonusNumber;
	}

	public void setWinningNumbers(List<Integer> numbers) throws LottoNumberException {
		if (numbers == null || numbers.size() != 6) {
			throw new LottoNumberLengthException();
		}
		this.winningNumber = new Lotto(numbers);
	}
}
