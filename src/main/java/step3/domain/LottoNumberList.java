package step3.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberList {
    private Set<LottoNumber> lottoNumberList;

    public LottoNumberList(Set<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public LottoNumberList(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = new HashSet<LottoNumber>(lottoNumberList);
    }

    public boolean contains(LottoNumber number) {
        return lottoNumberList.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumberList.stream().map(n->String.valueOf(n)).collect(Collectors.joining(",","[","]"));
    }
}
