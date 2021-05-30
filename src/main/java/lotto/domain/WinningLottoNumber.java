package lotto.domain;

import lotto.exception.AlreadyAppliedBonusNumberException;
import lotto.exception.DuplicatedBonusNumberException;

import static java.lang.Integer.parseInt;
import static lotto.domain.LottoNumber.valueOf;

public class WinningLottoNumber {
    private static final int MATCHING_BONUS_NUMBER  = 1;
    private static final int MISMATCHING_BONUS_NUMBER  = 0;

    private LottoGame prizeLottoNumber;
    private LottoNumber bonusLottoNumber;

    public WinningLottoNumber(LottoGame prizeLottoNumber) {
        this.prizeLottoNumber = prizeLottoNumber;
    }

    public LottoResult decidePrize(LottoGames lottoGames) {
        LottoResult lottoResult = new LottoResult();

        for (int i = 0; i < lottoGames.size(); i++) {
            LottoGame lottoGame = lottoGames.get(i);
            Rank rank = decidePrizeEachGame(lottoGame);
            lottoResult.put(rank);
        }

        return lottoResult;
    }

    public void applyBonusNumber(LottoNumber lottoNumber) {
        validateAlreadySet();
        validateBonusNumber(lottoNumber);

        this.bonusLottoNumber = lottoNumber;
    }

    private void validateAlreadySet() {
        if (bonusLottoNumber != null) {
            throw new AlreadyAppliedBonusNumberException();
        }
    }

    private void validateBonusNumber(LottoNumber bonusLottoNumber) {
        if (prizeLottoNumber.find(bonusLottoNumber)) {
            throw new DuplicatedBonusNumberException();
        }
    }

    private Rank decidePrizeEachGame(LottoGame lottoGame) {
        int prizeResult = prizeLottoNumber.compare(lottoGame);
        int bonusNumberResult = (lottoGame.find(bonusLottoNumber) ? MATCHING_BONUS_NUMBER : MISMATCHING_BONUS_NUMBER);
        return Rank.valueOf(prizeResult, bonusNumberResult);
    }
}
