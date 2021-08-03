package step3.strategy;

import step3.domain.Lotto;
import step3.domain.Winning;

import java.util.List;

public class LottoMatcher {
    public int matchLotto(Lotto winner, Lotto myLotto) {
        int count = 0;
        for (int number : myLotto.getNumbers()) {
            count = checkLotto(winner, number, count);
        }
        return count;
    }

    private int checkLotto(Lotto winner, int number, int count) {
        if (winner.getNumbers().contains(number)) {
            count++;
        }
        return count;
    }

    public Winning getWinning(int matchCount, boolean matchBonus) {
        if(matchCount == 5 && matchBonus){
            return Winning.SECOND;
        }
        return Winning.find(matchCount);
    }

    public boolean checkSeconds(Lotto myLotto, int bonus){
        if(myLotto.getNumbers().contains(bonus)){
            return true;
        }
        return false;
    }
}
