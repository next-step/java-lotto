package lotto;

import java.util.LinkedList;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers = new LinkedList<>();

    public LottoNumbers(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
