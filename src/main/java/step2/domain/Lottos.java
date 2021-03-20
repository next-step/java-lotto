package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos(Lotto lotto) {
        this.lottoList = new ArrayList<>();
        this.lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
