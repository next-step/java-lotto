package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    private final static int START_INDEX = 0;
    private final static int LAST_INDEX = 6;

    @Override
    public List<LottoNumber> generateLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.values());
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(START_INDEX, LAST_INDEX);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
