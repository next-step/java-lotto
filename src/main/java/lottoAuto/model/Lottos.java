package lottoAuto.model;

import java.util.List;
import java.util.Optional;

public class Lottos {
    private List<Lotto> lotto;

    public Lottos(List<Lotto> lotto){
        this.lotto = lotto;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

}
