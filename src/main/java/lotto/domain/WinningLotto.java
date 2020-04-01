package lotto.domain;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        if (this.winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
    }

    public int match(Lotto userLotto) {
        int matchCount = userLotto.match(winningLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return rank(matchCount, matchBonus);
    }

    private static int rank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && matchBonus) {
            return 2;
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2;
        }
        return 0;
    }
}
