package src.domain;

public class WinningLotto {

    private final Lotto lotto;

    private final GameNumber bonusNumber;

    private WinningLotto(Lotto lotto, GameNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, GameNumber bonusNumber) {
        boolean duplicateNumber = lotto.matchBonus(bonusNumber);
        if (duplicateNumber) {
            throw new IllegalArgumentException("보너스 번호는 이미 뽑힌 번호와 중복될 수 없습니다.");
        }

        return new WinningLotto(lotto, bonusNumber);
    }

    public Place match(Lotto lotto) {
        int matchCount = this.lotto.matchCount(lotto);
        boolean matchBonus = lotto.matchBonus(bonusNumber);

        return Place.byMatchCount(matchCount, matchBonus);
    }
}
