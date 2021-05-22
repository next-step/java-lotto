package study.lotto;

import java.util.*;

public class MarkedLottoNumbers {
    private static LottoNumbers lottoNumbers = new LottoNumbers();

    private List<Integer> markedlottoNumbers;

    public MarkedLottoNumbers(List<Integer> markedlottoNumbers) {
        this.markedlottoNumbers = markedlottoNumbers;
        Collections.sort(markedlottoNumbers);
    }

    public MarkedLottoNumbers() {
        this.markedlottoNumbers = lottoNumbers.autoCreatedNumbers();
    }

    public List<Integer> value() {
        return markedlottoNumbers;
    }

}
