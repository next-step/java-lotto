package secondplacelotto.model;


import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public MatchingNumbers match(Lotto winningNumbers, BonusNumber bonusNumber){

        MatchingNumbers matchingNumbers = new MatchingNumbers();

        for(Lotto lotto : lottos) {
            lotto.match(matchingNumbers, winningNumbers, bonusNumber);
        }

        return matchingNumbers;
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

}
