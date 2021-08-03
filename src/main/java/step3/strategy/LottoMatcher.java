package step3.strategy;

import step3.domain.Lotto;
import step3.domain.WinnerLotto;
import step3.domain.Winning;

public class LottoMatcher {
    public int matchLotto(Lotto myLotto, Lotto winner) {
        int count = 0;
        for (int number : myLotto.getNumbers()) {
            if(checkLotto(winner, number)){
                count++;
            }
        }
        return count;
    }

    private boolean checkLotto(Lotto winner, int number) {
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

    public boolean checkSeconds(Lotto myLotto, int bonus) {
        if (myLotto.getNumbers().contains(bonus)) {
            return true;
        }
        return false;
    }
}
