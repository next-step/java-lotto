package lotto.domain;

import java.util.List;

public class NonShuffleLottoNumber implements Shuffle {

    @Override
    public Lotto suffle(List<LottoNumber> lottonumber) {
        return new Lotto(lottonumber);
    }
}
