package lotto.entity;

import java.util.Collections;
import java.util.List;

public class LottoRandomizer {
    private final AllLottoNumbers allLottoNumbers;

    public LottoRandomizer() {
        allLottoNumbers = new AllLottoNumbers();
    }

    public List<LottoNumber> lottoShuffle() {
        Collections.shuffle(allLottoNumbers.getLottoNumbers());
        return allLottoNumbers.getLottoNumbers();
    }

}


