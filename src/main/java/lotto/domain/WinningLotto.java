package lotto.domain;

public class WinningLotto {

    private final Lotto lastWeakLotto;

    private final LottoNumber bonusBall;

    public WinningLotto(Lotto lastWeakLotto, LottoNumber bonusBall) {
        this.lastWeakLotto = lastWeakLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusBall) {
        return new WinningLotto(lotto, bonusBall);
    }

    public int compare(Lotto lotto) {
        return lastWeakLotto.matchCount(lotto);
    }

    public int compareBonus(Lotto lotto) {
        return lotto.lottoNumbers().stream().mapToInt(lottoNumber -> {
            if(lottoNumber.equals(bonusBall)){
                return 1;
            }
            return 0;
        }).sum();
    }
}
