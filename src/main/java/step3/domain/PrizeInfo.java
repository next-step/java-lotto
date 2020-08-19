package step3.domain;

import step3.LottoException;

import static step3.constants.MessageConstant.BONUS_NUMBER_SHOULD_NOT_CONTAINS_PRIZE_GAME;

public class PrizeInfo {

	private final LottoGame prizeLottoGame;

	private final LottoNumber bonusNumber;

	public PrizeInfo(LottoGame prizeLottoGame, LottoNumber bonusNumber) {
		validateBonusNumber(prizeLottoGame, bonusNumber);
		this.prizeLottoGame = prizeLottoGame;
		this.bonusNumber = bonusNumber;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return prizeLottoGame.contains(lottoNumber);
	}

	public boolean isMatchBonusNumber(LottoNumber lottoNumber) {
		return bonusNumber.equals(lottoNumber);
	}

	private void validateBonusNumber(LottoGame prizeLottoGame, LottoNumber bonusNumber) {
		if(prizeLottoGame.contains(bonusNumber)) {
			throw new LottoException(BONUS_NUMBER_SHOULD_NOT_CONTAINS_PRIZE_GAME);
		}
	}
}
