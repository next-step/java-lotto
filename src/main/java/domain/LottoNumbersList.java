package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbersList {
    private final List<LottoNumbers> lottoNumbersList;

    public LottoNumbersList(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public LottoNumbers get(int index) {
        return lottoNumbersList.get(index);
    }

    public boolean isSizeBiggerThan(int index) {
        return lottoNumbersList.size() > index;
    }

    public LottoNumbersList add(LottoNumbers lottoNumbers) {
        List<LottoNumbers> addedLottoNumbersList = new ArrayList<>(lottoNumbersList);
        addedLottoNumbersList.add(lottoNumbers);
        return new LottoNumbersList(addedLottoNumbersList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbersList that = (LottoNumbersList) o;
        return lottoNumbersList.equals(that.lottoNumbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbersList);
    }
}
