package study.ascii92der.lotto.step3;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumberArray) {
        lottoNumbers = new ArrayList<>();
        for (Integer value : lottoNumberArray) {
            lottoNumbers.add(new LottoNumber(value));
        }
    }

    public List<LottoNumber> generateNumber() {

        return lottoNumbers;
    }
}
