package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleLottoNumber implements Shuffle {

    @Override
    public Lotto suffle(List<LottoNumber> lottoNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList(lottoNumber);
        Collections.shuffle(lottoNumber);

        return new Lotto(lottoNumber);
    }
}
