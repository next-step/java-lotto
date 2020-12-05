package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public Lottos(Lotto lotto) {
        this();
        this.lottoList.add(lotto);
    }

    public Lottos(List<Lotto> lottoList) {
        this();
        this.lottoList.addAll(lottoList);
    }

    public int size() {
        return lottoList.size();
    }

    public void append(Lotto lotto) {
        lottoList.add(lotto);
    }

    public void append(List<Lotto> lottoList) {
        this.lottoList.addAll(lottoList);
    }

    public void append(Lottos lottos) {
        this.lottoList.addAll(lottos.lottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
