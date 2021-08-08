package lotto.model;

import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private List<Integer> lottoNumber = new ArrayList<>();

    public LottoNumber() {
        for (int number = LottoNumberUtil.getLottoStartNumber(); number <= LottoNumberUtil.getLottoEndNumber(); number++) {
            lottoNumber.add(number);
        }
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public void shuffle() {
        Collections.shuffle(this.lottoNumber);
    }

}
