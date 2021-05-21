package study.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = lottoNumbers();
    }

    private List<Integer> lottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<Integer> autoCreatedNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Integer> autoMarkedLottoNumbers =  lottoNumbers.subList(0,6);
        Collections.sort(autoMarkedLottoNumbers);
        return autoMarkedLottoNumbers;
    }

    public List<Integer> values() {
        return lottoNumbers;
    }
}
