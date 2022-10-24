package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.policy.LottoPolicy;

public class LottoMachine {

    private final LottoPolicy lottoPolicy;
    private final int quantity;

    public LottoMachine(LottoPolicy lottoPolicy, int quantity) {
        this.lottoPolicy = lottoPolicy;
        this.quantity = quantity;
    }

    public Lottos buyLotto() {
        List<Lotto> lottoList = IntStream.range(0, quantity)
            .mapToObj(__ -> lottoPolicy.ball())
            .collect(Collectors.toList());

        return new Lottos(lottoList);
    }

}
