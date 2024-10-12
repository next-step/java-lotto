package lotto.domain;

public class LastWeekWinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    public LastWeekWinningLotto(final Lotto lotto, final LottoNumber bonusLottoNumber) {
        if (lotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
        }

        this.lotto = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoRank calculateLottoRank(final Lotto otherLotto) {
        final int matchedCount = otherLotto.matchCount(lotto);
        final boolean isMatchedBonusNumber = otherLotto.contains(bonusLottoNumber);
        return LottoRank.findLottoRankByMatchedNumber(matchedCount, isMatchedBonusNumber);
    }
}
