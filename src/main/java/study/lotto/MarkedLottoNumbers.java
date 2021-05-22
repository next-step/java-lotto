package study.lotto;

import java.util.*;

public class MarkedLottoNumbers {
    private List<Integer> markedLottoNumbers;

    public MarkedLottoNumbers(List<Integer> markedLottoNumbers) {
        this.markedLottoNumbers = markedLottoNumbers;
        Collections.sort(markedLottoNumbers);
    }

    public MarkedLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        this.markedLottoNumbers = lottoNumbers.autoCreatedNumbers();
    }

    public List<Integer> value() {
        return markedLottoNumbers;
    }
}
