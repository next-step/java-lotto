package study.step2.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> collect) {
        lottoNumbers = this.sorted(collect);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> sorted(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
}
