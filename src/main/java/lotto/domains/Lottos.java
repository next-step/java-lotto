package lotto.domains;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int count() {
        return lottoList.size();
    }
}
