package domain;

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

    public boolean isSmallerThanSize(int index) {
        return lottoNumbersList.size() > index;
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
