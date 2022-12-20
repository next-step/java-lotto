package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList = new ArrayList<>();

    public Lottos(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public int buyCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
