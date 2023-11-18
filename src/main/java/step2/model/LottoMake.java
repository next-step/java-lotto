package step2.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMake {

    public static final int EACH_LOTTO_PRICE = 1000;

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
