package lotto.domain;

public class PreviousLotto {

    private Lotto previousLotto;
    private Ball bonusBall;

    private PreviousLotto(Lotto previousLotto, Ball bonusBall) {
        validBonusBall(previousLotto, bonusBall);
        this.previousLotto = previousLotto;
        this.bonusBall = bonusBall;
    }

    public static PreviousLotto of(Lotto previousLotto, Ball bonusBall) {
        return new PreviousLotto(previousLotto, bonusBall);
    }

    private void validBonusBall(Lotto previousLotto, Ball bonusBall) {
        if (previousLotto.containBonusBall(bonusBall)) {
            throw new IllegalArgumentException("보너스 공은 지난 주 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Reward match(Lotto lotto) {
        int sameNumberCount = lotto.getSameNumberCount(previousLotto);
        boolean containBonusBall = lotto.containBonusBall(bonusBall);
        return Reward.valueOf(sameNumberCount, containBonusBall);
    }
}
