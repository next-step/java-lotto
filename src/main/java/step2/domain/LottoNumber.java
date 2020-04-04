package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private List<Integer> lottoNumbers;

    public LottoNumber() {
        lottoNumbers = new ArrayList<>();
    }

    public List<Integer> initializeLottoNumber() {
        for (int i = 1; i <= LottoConstant.LOTTO_NUMBER_RANGE; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);

        return lottoNumbers;
    }


}
