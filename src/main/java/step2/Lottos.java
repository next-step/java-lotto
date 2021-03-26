package step2;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }
}
