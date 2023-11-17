package step2.model;

import java.util.ArrayList;
import java.util.List;

import static step2.model.Lotto.EACH_LOTTO_PRICE;

public class LottoMake {

    private final int lottoPayPrice;

    public LottoMake(int lottoPayPrice) {
        this.lottoPayPrice = lottoPayPrice;
    }

    public List<Lotto> makeLottos() {
        int lottoCount = this.lottoPayPrice / EACH_LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i < lottoCount; i++) {
            lottos.add(new Lotto(new LottoNumber().getNumber()));
        }

        return lottos;
    }
}
