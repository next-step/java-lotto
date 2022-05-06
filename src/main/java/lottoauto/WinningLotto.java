package lottoauto;

public class WinningLotto {
    private final Lotto winnig;
    private final LottoNumber bonus;

    private WinningLotto(Lotto winnig, LottoNumber bonus) {
        this.winnig = winnig;
        this.bonus = bonus;
    }

    public static WinningLotto of(Lotto winnig, LottoNumber bonus) {
        return new WinningLotto(winnig, bonus);
    }

    public static WinningLotto from(Lotto lotto) {
        return new WinningLotto(lotto, null);
    }

    public Rating findRating(Lotto lotto) {
        return Rating.from(winnig.findMatchingCount(lotto));
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "winnig=" + winnig +
                ", bonus=" + bonus +
                '}';
    }
}
