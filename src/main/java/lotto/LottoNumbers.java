package lotto;

import java.util.*;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = getSortedNumbers(lottoNumbers);
    }

    private List<Integer> getSortedNumbers(List<Integer> lottoNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
