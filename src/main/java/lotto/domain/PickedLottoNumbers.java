package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickedLottoNumbers implements Iterable<LottoNumber> {
    private List<LottoNumber> lottoNumberList;

    public PickedLottoNumbers() {
        this.lottoNumberList = new ArrayList<>();
    }

    public void save(LottoNumber lottoNumbers) {
        lottoNumberList.add(lottoNumbers);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumberList.iterator();
    }
}
