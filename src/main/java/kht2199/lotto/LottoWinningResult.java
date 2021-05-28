package kht2199.lotto;

import kht2199.Rank;
import kht2199.lotto.data.LottoList;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.LottoGameStateException;
import kht2199.lotto.exception.LottoWinningNumberNotInitiatedException;
import kht2199.lotto.exception.number.LottoNumberException;
import kht2199.lotto.exception.rank.OutOfRangeOfMatchedCountException;

/**
 * @author heetaek.kim
 */
public class LottoWinningResult {

	private final LottoPrizeResult lottoPrizeResult;

	private LottoNumbers winningNumber;

	private LottoNumber bonusNumber;

	public LottoWinningResult() {
		this.lottoPrizeResult = new LottoPrizeResult();
	}

	/**
	 * 당첨 갯수, 당첨 금액 설정
	 */
	public void updateLottoWinningNumbers(LottoList list) throws LottoGameStateException {
		if (winningNumber == null) {
			throw new LottoGameStateException("당첨번호가 설정되어 있지 않습니다.");
		}
		if (bonusNumber == null) {
			throw new LottoGameStateException("보너스 번호가 설정되어 있지 않습니다.");
		}
		lottoPrizeResult.reset();
		for (LottoNumbers lotto : list.getList()) {
			Rank rank = calculateMatched(lotto);
			lottoPrizeResult.addWinningMoney(rank);
		}
	}

	/**
	 * @param lotto 비교대상 로또.
	 * @return 결과정보.
	 */
	protected Rank calculateMatched(LottoNumbers lotto) {
		int matched = winningNumber.countMatched(lotto);
		if (matched == 5L && lotto.contains(bonusNumber)) {
			return Rank.SECOND;
		}
		try {
			return Rank.valueOf(matched, false);
		} catch (OutOfRangeOfMatchedCountException e) {
			// 발생할 여지가 없어야하기 때문에, RuntimeException 으로 적용.
			throw new RuntimeException(e);
		}
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

	public void setBonusNumber(LottoNumber bonusNumber)
			throws LottoBonusNumberDuplicatedException, LottoWinningNumberNotInitiatedException {
		if (winningNumber == null) {
			throw new LottoWinningNumberNotInitiatedException();
		}
		if (winningNumber.contains(bonusNumber)) {
			throw new LottoBonusNumberDuplicatedException();
		}
		this.bonusNumber = bonusNumber;
	}

	public void setWinningNumbers(LottoNumbers numbers) throws LottoNumberException {
		this.winningNumber = numbers;
	}

	public LottoPrizeResult priseResult() {
		return lottoPrizeResult;
	}
}
