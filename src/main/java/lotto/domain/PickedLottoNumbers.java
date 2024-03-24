package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickedLottoNumbers implements Iterable<LottoNumbers> {
    private List<LottoNumbers> lottoNumbersList;

    public PickedLottoNumbers() {
        this.lottoNumbersList = new ArrayList<>();
    }

    public void save(LottoNumbers lottoNumbers) {
        lottoNumbersList.add(lottoNumbers);
    }

    @Override
    public Iterator<LottoNumbers> iterator() {
        return lottoNumbersList.iterator();
    }
}
