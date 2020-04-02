package step3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumberList {

    private List<LottoNumber> lottoNumberList;

    public LottoNumberList(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public boolean contains(LottoNumber number) {
        return this.lottoNumberList.contains(number);
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumberList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberList that = (LottoNumberList) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }

    public int size() {
        return this.lottoNumberList.size();
    }
}
