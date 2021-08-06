package app.strategy;

import app.domain.Winning;
import app.domain.lotto.Lotto;
import app.domain.lotto.LottoNum;
import app.domain.lotto.WinnerLotto;

public class LottoMatcher {
    public int matchLotto(Lotto myLotto, Lotto winner) {
        int count = 0;
        for (LottoNum number : myLotto.getNumbers()) {
            if (checkLotto(winner, number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkLotto(Lotto winner, LottoNum number) {
        return winner.getNumbers().contains(number);
    }

    public Winning getWinning(int matchCount, boolean matchBonus) {
        return Winning.find(matchCount, matchBonus);
    }

    public Winning getWinning(Lotto myLotto, WinnerLotto winnerLotto) {
        int matchCount = matchLotto(myLotto, winnerLotto.getLotto());
        boolean matchBonus = checkSeconds(myLotto, winnerLotto.getBonus());
        return getWinning(matchCount, matchBonus);
    }

    public boolean checkSeconds(Lotto myLotto, LottoNum bonus) {
        if (myLotto.getNumbers().contains(bonus)) {
            return true;
        }
        return false;
    }
}
