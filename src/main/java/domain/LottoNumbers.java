package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);
    }


    public List<Integer> getValues() {
        return lottoNumbers;
    }
}
