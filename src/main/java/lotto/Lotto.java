package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    public void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public void sort(){
        lottoNumbers.sort(Integer::compareTo);
    }
}
