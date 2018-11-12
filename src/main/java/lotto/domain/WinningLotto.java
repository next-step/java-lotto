package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, int no) {
        this.bonusNo = LottoNumber.of(no);
        if (lotto.contains(bonusNo)) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = lotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonusNo);
        return Rank.valueOf(matchCount, matchBonus);
    }
}
