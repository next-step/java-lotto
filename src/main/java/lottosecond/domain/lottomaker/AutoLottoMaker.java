package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoCount;
import lottosecond.domain.lotto.Lottos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AutoLottoMaker {

    private final LottoNumberGenerator lottoMaker;

    public AutoLottoMaker(LottoNumberGenerator lottoMaker) {
        this.lottoMaker = lottoMaker;
    }

    public Lottos makeLottos(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(new HashSet<>(lottoMaker.makeLottoNumberList())));
        }

        return new Lottos(lottoList);
    }
}
