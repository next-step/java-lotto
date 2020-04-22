package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        lottoNumbers = new ArrayList<>();
    }

    public LottoNumbers(String[] lottoNumbers) {
        this();
        for (int i = 0; i < lottoNumbers.length; i++) {
            this.lottoNumbers.add(new LottoNumber(Integer.parseInt(lottoNumbers[i])));
        }
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public LottoNumber getNumber(int index) {
        return lottoNumbers.get(index);
    }
}
