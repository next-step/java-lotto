package lotto.domain;

import java.util.List;

public class Lottos {
    private List<LottoNumbers> lottos;

    public Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public LottoNumbers getLottoNumbers(int index) {
        return this.lottos.get(index);
    }

    public int getSize() {
        return this.lottos.size();
    }
}
