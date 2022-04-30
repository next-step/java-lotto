package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers randomLottoNumbers() {
        List<LottoNumber> random = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
            random.add(lottoNumbers.get(i));
        }
        return new LottoNumbers(random);
    }

    public boolean isSameCount(int count) {
        return lottoNumbers.size() == count;
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
