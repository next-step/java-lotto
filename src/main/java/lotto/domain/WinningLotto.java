package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto(List<Integer> winningNumbers){
        winningLotto = new Lotto(winningNumbers);
    }

    public int matchCount(Lotto myLotto){
        int matchCount = 0;

        for(int i = 0; i < myLotto.numbers().size(); i++){
            matchCount = myLotto.addMatchCount(matchCount, winningLotto.numberOf(i));
        }

        return matchCount;
    }
}
