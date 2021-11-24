package step3.model;

import java.util.Collections;
import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottoList;

    public LottoBundle(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }
}
