package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class PickedLottoNumbers implements Iterable<LottoNumbers> {

    private final List<LottoNumbers> lottoNumbersList;

    public PickedLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    @Override
    public Iterator<LottoNumbers> iterator() {
        return lottoNumbersList.iterator();
    }
}
