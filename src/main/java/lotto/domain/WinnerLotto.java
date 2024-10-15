package lotto.domain;

public class WinnerLotto {
    private final Lotto winnerLotto;
    private final LottoNum winnerBonusNum;

    public WinnerLotto(Lotto lotto, LottoNum lottoNum) {
        this.winnerLotto = lotto;
        this.winnerBonusNum = lottoNum;
    }

    public int compareWinningNumber(Lotto lotto) {
        int result = 0;
        for (LottoNum lottoNumber : lotto.getLottoNumbers()) {
            result += addResult(lottoNumber);
        }
        return result;
    }

    private int addResult(LottoNum lottoNumber) {
        if (winnerLotto.getLottoNumbers().contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean isMatchBonus(Lotto lotto) {
        return lotto.isContains(winnerBonusNum);
    }
}
