package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers){
        winningLotto = new Lotto(winningNumbers);
    }

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber){
        this(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private int matchCount(Lotto myLotto){
        int matchCount = 0;

        for(int i = 0; i < myLotto.numbers().size(); i++){
            matchCount = myLotto.addMatchCount(matchCount, winningLotto.numberOf(i));
        }

        return matchCount;
    }

    public Rank matchRank(Lotto lotto) {
        int myMatchCount = matchCount(lotto);
        if(myMatchCount == 5 && lotto.isMatchBonusNumber(bonusNumber)){
            return Rank.SECOND;
        }
        if(myMatchCount == 5 && !lotto.isMatchBonusNumber(bonusNumber)){
            return Rank.THIRD;
        }

        return Rank.returnRank(myMatchCount);
    }
}
