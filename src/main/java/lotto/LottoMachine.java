package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    public Lottos buyLotto(Money money) {
        int quotient = money.divide(PRICE_PER_ONE_LOTTO);
        return new Lottos(createLottos(quotient));
    }

    private List<Lotto> createLottos(int quotient) {
        return IntStream.range(0, quotient)
                .mapToObj(it -> new Lotto(LottoNumbers.random()))
                .collect(Collectors.toList());
    }

    public LottoSummary summarizeLotto(LottoNumbers winningLottoNumbers, Lottos lottos) {
        return new LottoSummary(lottos.createResult(winningLottoNumbers), new Money(getPayMoney(lottos.count())));
    }

    private int getPayMoney(int buyLottoCount) {
        return buyLottoCount * PRICE_PER_ONE_LOTTO;
    }
}
