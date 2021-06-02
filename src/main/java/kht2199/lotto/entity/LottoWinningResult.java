package kht2199.lotto.entity;

import java.util.Map;

import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;

/**
 * 로또 게임 결과 정보
 *
 * @author heetaek.kim
 */
public class LottoWinningResult {

	private final LottoPrizeResult lottoPrizeResult;

	private final Lotto winningNumber;

	private final LottoNumber bonusNumber;

	public LottoWinningResult(Lotto winningNumber, LottoNumber bonusNumber) throws LottoBonusNumberDuplicatedException {
		if (winningNumber.contains(bonusNumber)) {
			throw new LottoBonusNumberDuplicatedException();
		}
		this.lottoPrizeResult = new LottoPrizeResult();
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}

	/**
	 * 당첨 갯수, 당첨 금액 설정
	 */
	public void updateLottoWinningNumbers(LottoList list) {
		lottoPrizeResult.reset();
		Rank[] ranks = list.calculateRanks(winningNumber, bonusNumber);
		lottoPrizeResult.addWinningMoney(ranks);
	}

	public int getTotalPrize() {
		return lottoPrizeResult.totalPrize();
	}

	public Map<Rank, Integer> rankPrizeMap() {
		return lottoPrizeResult.getMatchedPrizeMap();
	}

}
