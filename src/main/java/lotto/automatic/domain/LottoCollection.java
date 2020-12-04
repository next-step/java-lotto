package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {

    private final List<Lotto> lottoList;

    public LottoCollection() {
        this.lottoList = new ArrayList<>();
    }

    public LottoCollection(Lotto lotto) {
        this();
        this.lottoList.add(lotto);
    }

    public LottoCollection(List<Lotto> lottoList) {
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

    public void append(LottoCollection collection) {
        this.lottoList.addAll(collection.lottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
