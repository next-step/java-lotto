package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers = Collections.EMPTY_LIST;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    public void sort(){
        lottoNumbers.sort(Integer::compareTo);
    }
}
