package step2.vo;

import step2.service.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto pickSixNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> pickedNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(pickedNumbers);
        return new Lotto(pickedNumbers);
    }
}
