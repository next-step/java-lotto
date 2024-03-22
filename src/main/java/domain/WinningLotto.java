package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Ranks ranks(Lottos lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(this.rank(lotto));
        }
        return new Ranks(ranks);
    }

    public Rank rank(Lotto lotto) {
        List<Integer> matchNumbers = matchNumbers(lotto);
        List<Integer> noMatchNumbers = noMatchNumbers(lotto);
        if (matchNumbers.size() == 5 && noMatchNumbers.contains(bonusNumber)) {
            return Rank.SECOND;
        }

        return Rank.of(matchNumbers.size());
    }

    private List<Integer> matchNumbers(Lotto lotto) {
        List<Integer> matchNumbers = lotto.numbers();
        matchNumbers.retainAll(winningNumbers);
        return matchNumbers;
    }

    private List<Integer> noMatchNumbers(Lotto lotto) {
        List<Integer> noMatchNumbers = lotto.numbers();
        noMatchNumbers.removeAll(winningNumbers);
        return noMatchNumbers;
    }
}
