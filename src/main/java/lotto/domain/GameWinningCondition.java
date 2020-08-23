package lotto.domain;

import lotto.LottoException;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.MessageConstant.BONUS_NUMBER_SHOULD_NOT_CONTAINS_PRIZE_GAME;
import static lotto.domain.LottoGameFactory.getNewManualGame;
import static lotto.domain.LottoNumberFactory.getNewLottoNumber;

public class GameWinningCondition {

	private final LottoGame prizeLottoGame;

	private final LottoNumber bonusNumber;

	public GameWinningCondition(LottoGame prizeLottoGame, LottoNumber bonusNumber) {
		validateBonusNumber(prizeLottoGame, bonusNumber);
		this.prizeLottoGame = prizeLottoGame;
		this.bonusNumber = bonusNumber;
	}

	public List<PrizeGrade> getPrizeResult(List<LottoGame> lottoGames) {
		return lottoGames.stream()
				.map(this::confirmPrize)
				.collect(Collectors.toList());
	}

	private void validateBonusNumber(LottoGame prizeLottoGame, LottoNumber bonusNumber) {
		if (prizeLottoGame.contains(bonusNumber)) {
			throw new LottoException(BONUS_NUMBER_SHOULD_NOT_CONTAINS_PRIZE_GAME);
		}
	}

	private PrizeGrade confirmPrize(LottoGame lottoGame) {
		return PrizeGrade.of(getMatchCount(lottoGame), containsBonusNumber(lottoGame));
	}

	private int getMatchCount(LottoGame lottoGame) {
		return (int) lottoGame.getLottoNumbers()
						.stream()
						.filter(prizeLottoGame::contains)
						.count();

	}

	private boolean containsBonusNumber(LottoGame lottoGame) {
		return lottoGame.getLottoNumbers()
				.stream()
				.anyMatch(bonusNumber::equals);
	}

}
