package game.lotto.model;

public class WinningLotto{

    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 로또 번호에 포함되어 있습니다.");
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Match match(Lotto target) {

        int matchOfCount = this.lotto.getMatchOfCount(target);

        Rank rank = Rank.valueOf(matchOfCount, target, bonusNumber);

        return new Match(rank);
    }

}
