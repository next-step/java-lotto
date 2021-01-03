package secondplacelotto.model;


import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public void match(Lotto winningNumbers, BonusNumber bonusNumber){
        for(Lotto lotto : lottos) {
            lotto.match(winningNumbers, bonusNumber);
        }
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

}
