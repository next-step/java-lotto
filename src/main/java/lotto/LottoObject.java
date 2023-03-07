package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoObject {
    List<Integer> lottoNumbers;

    public LottoObject(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoObject() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void setLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    public void add(Integer lottoNumber) {
        lottoNumbers.add(lottoNumber);
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return String.valueOf(lottoNumbers);
    }
}
