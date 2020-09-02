package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto){
        lottos.add(lotto);
    }

    public int getSize(){
        return lottos.size();
    }

    public Winners getWinner(WinningLotto winningNumbers){
        Winners winners = new Winners(winningNumbers);

        for(Lotto lotto : lottos){
            winners.addLotto(lotto);
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
