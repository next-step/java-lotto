package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    public Lottos sell(long price, LottoNumGenerator lottoNumGenerator){
        List<Lotto> lottos =  Stream.generate(() -> getLotto(lottoNumGenerator))
            .limit(getLottoCount(price))
            .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public Lottos sell(long price) {
        return sell(price, new AutoLottoNumGenerator());
    }

    private int getLottoCount(long price) {
        return (int) (price / 1000);
    }

    private Lotto getLotto(LottoNumGenerator lottoNumGenerator) {
        return new Lotto(getLottoNums(lottoNumGenerator));
    }

    private LottoNums getLottoNums(LottoNumGenerator lottoNumGenerator) {
        return new LottoNums(Stream.generate(() -> new LottoNum(lottoNumGenerator.generateNum()))
            .limit(6)
            .collect(Collectors.toList()));
    }
}
