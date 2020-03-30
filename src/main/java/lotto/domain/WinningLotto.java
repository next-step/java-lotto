package lotto.domain;

public class WinningLotto {
    private static final int FIVE_MATCH_COUNT = 5;
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(String lottoNumber, int bonusNumber) {
        this.winningLotto = new Lotto(lottoNumber);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
    }

    public WinningType checkWinning(Lotto lotto) {
        long matchCount = winningLotto.getLottoNumbers().stream()
                .filter(lottoNumber -> lotto.isContainsLottoNumber(lottoNumber))
                .count();

        return WinningType.findLottoWinningtype(matchCount, isBonusMatch(lotto, matchCount));
    }

    private boolean isBonusMatch(Lotto lotto, long matchCount) {
        if (isWinningFive(matchCount)) {
            return lotto.isContainsLottoNumber(bonusNumber);
        }
        return false;
    }

    private boolean isWinningFive(long matchCount) {
        return matchCount == FIVE_MATCH_COUNT;
    }
}
