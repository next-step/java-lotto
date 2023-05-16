package lotto.domian;

public class WinNumber {

    private final Lotto winNumber;
    private final LottoNumber bonusWinNumber;

    public WinNumber(Lotto lotto, LottoNumber bonusWinNumber) {
        this.winNumber = lotto;
        this.bonusWinNumber = bonusWinNumber;
        validDuplicate();
    }

    public Rank matchRank(Lotto lotto) {
        int matchingCount = distinguish(lotto);
        boolean haveBonus = haveBonus(lotto);
        return Rank.find(new MatchCount(matchingCount), haveBonus);
    }

    private int distinguish(Lotto lotto) {
        return lotto.match(winNumber);
    }

    private boolean haveBonus(Lotto lotto) {
        return lotto.haveNumber(bonusWinNumber);
    }

    private void validDuplicate() {
        if (winNumber.getLottoNumbers().contains(bonusWinNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호들(6개)과 중복될 수 없습니다.");
        }
    }

}
