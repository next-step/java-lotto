package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final LottoPolicy lottoPolicy;
    private final LottoPrice lottoPrice;

    public LottoMachine(LottoPolicy lottoPolicy, LottoPrice lottoPrice) {
        this.lottoPolicy = lottoPolicy;
        this.lottoPrice = lottoPrice;
    }

    public Lottos buyLotto(int purchaseMoney) {
        int lottoCount = lottoPrice.lottoCount(purchaseMoney);

        List<Lotto> lottoList = IntStream.range(0, lottoCount)
            .mapToObj(__ -> lottoPolicy.ball())
            .collect(Collectors.toList());
        return new Lottos(lottoList);
    }
}
