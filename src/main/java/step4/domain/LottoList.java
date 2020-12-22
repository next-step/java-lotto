package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList = new ArrayList<>();

    public void add(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }
}
