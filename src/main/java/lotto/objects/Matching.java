package lotto.objects;

import java.util.ArrayList;
import java.util.List;

public class Matching {
    private final Lottos createdLottos;
    private final Lotto lastWinningLotto;
    private final BonusBall bonusBall;

    public Matching(Lottos createdLottos, Lotto lastWinningLotto, BonusBall bonusBall) {
        this.createdLottos = createdLottos;
        this.lastWinningLotto = lastWinningLotto;
        this.bonusBall = bonusBall;
    }

    public List<WinningType> getWinningStatistics() {
        List<WinningType> wins = new ArrayList<>();
        for (Lotto lotto : createdLottos.getLottos()) {
            wins.add(findSameNumbers(lotto));
        }

        return wins;
    }

    public WinningType findSameNumbers(Lotto myLotto) {
        int matchCount = myLotto.countSameNumbers(lastWinningLotto);

        return decideWinningType(matchCount, myLotto);
    }

    public WinningType decideWinningType(int count, Lotto myLotto) {
        if (count == WinningType.THREE.getCounts()) {
            return WinningType.THREE;
        }
        if (count == WinningType.FOUR.getCounts()) {
            return WinningType.FOUR;
        }
        if (count == WinningType.FIVE.getCounts()) {
            return compareBonusNumber(myLotto);
        }
        if (count == WinningType.SIX.getCounts()) {
            return WinningType.SIX;
        }
        return WinningType.LOSE;
    }

    public WinningType compareBonusNumber(Lotto myLotto) {
        if (myLotto.getNumbers().contains(bonusBall.getNumber())) {
            return WinningType.FIVE_AND_BONUS;
        }
        return WinningType.FIVE;
    }

}
