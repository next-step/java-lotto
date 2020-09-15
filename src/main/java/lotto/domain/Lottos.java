package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto)
    {
        this.lottos.add(lotto);
    }

    public void addAll(List<Lotto> lottos){
        this.lottos.addAll(lottos);
    }
    public int getSize(){
        return lottos.size();
    }

    public Winners getWinner(WinningLotto winningLotto){
        Winners winners = new Winners();

        for(Lotto lotto : lottos){
            Rank rank = winningLotto.countWinningNumber(lotto);
            winners.addRank(rank);
        }

        return winners;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(Lotto lotto : lottos){
            str.append(lotto.toString()).append("\n");
        }

        return str.toString();
    }
}
