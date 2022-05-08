package lottoauto.domain;

public class WinningLotto {
    private final Lotto winnig;
    private final LottoNumber bonus;

    private WinningLotto(Lotto winnig, LottoNumber bonus) {
        this.winnig = winnig;
        this.bonus = bonus;
    }

    public static WinningLotto from(Lotto lotto) {
        return new WinningLotto(lotto, null);
    }

    public static WinningLotto of(Lotto winnig, LottoNumber bonus) {
        if (winnig.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호가 중복되었습니다.");
        }
        return new WinningLotto(winnig, bonus);
    }

    public Rating findRating(Lotto lotto) {
        int countOfMatch = winnig.findMatchingCount(lotto);
        if (!hasBonusNumber(lotto)) {
            return Rating.valueOf(countOfMatch, false);
        }
        return Rating.valueOf(countOfMatch, lotto.contains(bonus));
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return bonus != null && lotto.contains(bonus);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "winnig=" + winnig +
                ", bonus=" + bonus +
                '}';
    }
}
