package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class PickedLottoNumbers implements Iterable<LottoNumber> {
    private List<LottoNumber> lottoNumberList;

    public void save(LottoNumber lottoNumber) {
        lottoNumberList.add(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumberList.iterator();
    }
}
