package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    final LottoNumsGenerator lottoNumsGenerator = new LottoNumsGenerator();

    public Lottos sell(long price){
        List<Lotto> lottos =  Stream.generate(() -> createLotto())
            .limit(getLottoCount(price))
            .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    private int getLottoCount(long price) {
        return (int) (price / 1000);
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumsGenerator.generate());
    }

}
