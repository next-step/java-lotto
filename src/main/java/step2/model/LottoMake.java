package step2.model;

import step2.utils.CalculateUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoMake {

    private final int lottoPayPrice;

    public LottoMake(int lottoPayPrice) {
        this.lottoPayPrice = lottoPayPrice;
    }

    public List<Lotto> makeLottos() {
        int lottoCount = CalculateUtils.lottoCount(this.lottoPayPrice);

        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i < lottoCount; i++) {
            lottos.add(new Lotto(new LottoNumber().getNumber()));
        }

        return lottos;
    }
}
