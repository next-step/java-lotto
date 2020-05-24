package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
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
