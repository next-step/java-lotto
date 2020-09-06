package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winners {
    private Map<Rank, Count> winners = new HashMap<>();
    private final WinningLotto winningLotto;

    public Winners(WinningLotto winningLotto){
        this.winningLotto = winningLotto;
        init();
    }

    private void init(){
        for(Rank rank : Rank.values()){
            winners.put(rank, Count.ZERO);
        }
    }

    public void addLotto(Lotto lotto){
        Rank rank = winningLotto.countWinningNumber(lotto);

        winners.put(rank, winners.get(rank).increase());
    }

    public Count getWinnersCount(Rank rank){
        return winners.get(rank);
    }
}
