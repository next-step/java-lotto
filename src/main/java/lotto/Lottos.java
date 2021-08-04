package lotto;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        this.lottos = Stream.generate(Lotto::new)
                .limit(lottoCount)
                .collect(toList());
    }

    public int getSize() {
        return lottos.size();
    }
}
