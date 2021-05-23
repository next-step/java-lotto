package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private List<LottoNumber> lottoNubmers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNubmers, that.lottoNubmers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNubmers);
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNubmers.contains(lottoNumber);
    }

    public LottoNumbers(List<LottoNumber> lottoNubmers) {
        this.lottoNubmers = lottoNubmers;
    }

}
